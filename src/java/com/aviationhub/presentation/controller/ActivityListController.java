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
import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 * A page controller of the activity list page
 * @author ian
 */
@Named
@ViewScoped
public class ActivityListController implements Serializable {

    private ActivityTypeEnum activityType;
     
    /**
     * populate the activity list on the page
     * @return a list of activity DTOs
     * @throws NamingException
     * @throws SQLException
     */
        public List<ActivityDTO> getActivityList() throws NamingException, SQLException {
        //create DAO objects for different types of activities
        DAOFactory dAOFactory = DAOFactory.getFactory(DBTypeEnum.JAVADB);
        GenericDAO joyFlightDAO = dAOFactory.getActivityDAO(ActivityTypeEnum.JOYFLIGHT);
        GenericDAO pilotTrainingDAO = dAOFactory.getActivityDAO(ActivityTypeEnum.PILOTTRAINING);
        //query existing activities into two lists
        List<ActivityDTO> joyFlightList = joyFlightDAO.findAll();
        List<ActivityDTO> pilotTrainingList = pilotTrainingDAO.findAll();
        //merge the two lists
        List<ActivityDTO> activityList = new ArrayList<>();
        activityList.addAll(joyFlightList);
        activityList.addAll(pilotTrainingList);

        return activityList;
    }

    /**
     * navigate to new activity pages according to user select
     * @return navigate to activity creation page
     */
        public String createNewActivity() {
        if (activityType == ActivityTypeEnum.JOYFLIGHT) {
            return "newactivity?type=JOYFLIGHT&faces-redirect=true";
        } else if (activityType == ActivityTypeEnum.PILOTTRAINING) {
            return "newactivity?type=PILOTTRAINING&faces-redirect=true";
        } else {
            return null;
        }
    }


    //getters and setters
    /**
     * @return the activityType
     */
    public ActivityTypeEnum getActivityType() {
        return activityType;
    }

    /**
     * @param activityType the activityType to set
     */
    public void setActivityType(ActivityTypeEnum activityType) {
        this.activityType = activityType;
    }

}
