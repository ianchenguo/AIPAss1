/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.DAO.ActivityDAO;
import com.aviationhub.business.DAO.DAOFactory;
import com.aviationhub.business.DAO.DBTypeEnum;
import com.aviationhub.business.DTO.Activity.ActivityDTO;
import com.aviationhub.business.DTO.Activity.ActivityDTOSimpleFactory;
import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 *
 * @author ian
 */
@Named
@ViewScoped
public class ActivityController implements Serializable {

    private ActivityDTO activity;
    private DAOFactory dAOFactory;
    private ActivityDAO activityDAO;
    
    //initialise the DTO,DAO properties dynamically depending on the page content
    public void init(ActivityTypeEnum type) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        
        
        activity = ActivityDTOSimpleFactory.createActivity(type);
        dAOFactory = DAOFactory.getFactory(DBTypeEnum.JAVADB);
        activityDAO = dAOFactory.getActivityDAO(activity.getType());
    }

    //insert new activity entry into the database
    public String createActivity() throws NamingException, SQLException {
        activityDAO.addActivity(activity);
        return "activitylist";
    }

    //load a single activity from the database to details page
    public void loadActivity(int id, ActivityTypeEnum type) throws NamingException, SQLException {
        init(type);
        activity = activityDAO.findActivity(id);
    }

    //update a single activity into the database
    public String updateActivity() throws NamingException, SQLException {
        activityDAO.updateActivity(activity);
        return "activitylist";
    }

    //delete a single activity in a database
    public String deleteActivity() throws NamingException, SQLException {
        activityDAO.deleteActivity(activity.getId());
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
