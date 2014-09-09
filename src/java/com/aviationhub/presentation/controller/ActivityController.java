/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.DAO.DAOFactory;
import com.aviationhub.business.DAO.DBTypeEnum;
import com.aviationhub.business.DAO.GenericDAO;
import com.aviationhub.business.DTO.Activity.ActivityDTO;
import com.aviationhub.business.DTO.Activity.ActivityDTOSimpleFactory;
import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 * A page controller for pages of single activity
 * @author ian
 */
@Named
@ViewScoped
public class ActivityController implements Serializable {

    private ActivityDTO activity;
    private DAOFactory dAOFactory;
    private GenericDAO<ActivityDTO,Integer> activityDAO;

    /**
     * initialize the DTO,DAO properties dynamically depending on the page content
     * @param type
     */
    public void init(ActivityTypeEnum type) {
        activity = ActivityDTOSimpleFactory.createActivity(type);
        dAOFactory = DAOFactory.getFactory(DBTypeEnum.JAVADB);
        activityDAO = dAOFactory.getActivityDAO(activity.getType());
    }

    /**
     * insert new activity entry into the database
     * @return navigate to activity list page
     * @throws NamingException
     * @throws SQLException
     */
        public String createActivity() throws NamingException, SQLException {
        activityDAO.addEntry(activity);
        return "activitylist";
    }

    /**
     * load a single activity from the database to details page
     * @param id
     * @param type
     * @throws NamingException
     * @throws SQLException
     */
        public void loadActivity(int id, ActivityTypeEnum type) throws NamingException, SQLException {
        init(type);
        activity = activityDAO.findEntry(id);
    }

    /**
     * update a single activity into the database
     * @return navigate to activity list page
     * @throws NamingException
     * @throws SQLException
     */
        public String updateActivity() throws NamingException, SQLException {
        activityDAO.updateEntry(activity);
        return "activitylist";
    }

    /**
     * delete a single activity in a database
     * @return navigate to activity list page
     * @throws NamingException
     * @throws SQLException
     */
        public String deleteActivity() throws NamingException, SQLException {
        activityDAO.deleteEntry(activity.getId());
        return "activitylist";
    }

    //setters and getters
    /**
     * @return the activity
     */
    public ActivityDTO getActivity() {
        return activity;
    }
}
