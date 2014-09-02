/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.DAO.DAODBTypeEnum;
import com.aviationhub.business.DAO.DAOFactory;
import com.aviationhub.business.DAO.JoyFlightDAO;
import com.aviationhub.business.DAO.PilotTrainingDAO;
import com.aviationhub.business.DTO.Activity.ActivityDTO;
import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import com.aviationhub.business.DTO.Activity.JoyFlightDTO;
import com.aviationhub.business.DTO.Activity.PilotTrainingDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 *
 * @author ian
 */
@Named
@RequestScoped
public class ActivityListController {
    
    private ActivityTypeEnum activityType;
    private DAOFactory dAOFactory = DAOFactory.getFactory(DAODBTypeEnum.JAVADB);
    
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
    
    public String createNewActivity() {
        if (activityType == ActivityTypeEnum.JOYFLIGHT) {
            return "/faces/activity/newactivity?faces-redirect=true&type=joyflight";
        } else if (activityType == ActivityTypeEnum.PILOTTRAINING) {
            return "/faces/activity/newactivity?faces-redirect=true&type=pilottraining";
        } else {
            return null;
        }
    }

    public List<ActivityDTO> getActivityList() throws NamingException, SQLException {
        
        JoyFlightDAO joyFlightDAO = dAOFactory.getJoyFlightDAO();
        PilotTrainingDAO pilotTrainingDAO = dAOFactory.getPilotTrainingDAO();
        
        List<JoyFlightDTO> joyFlightList = joyFlightDAO.findAll();
        List<PilotTrainingDTO> pilotTrainingList = pilotTrainingDAO.findAll();
        
        List<ActivityDTO> activityList = new ArrayList<>();
        activityList.addAll(joyFlightList);
        activityList.addAll(pilotTrainingList);
        
        return activityList;
    }

    
    
    public String getDeleteTarget(ActivityTypeEnum type,int id) {
        
        if (type == ActivityTypeEnum.JOYFLIGHT) {
            return "deletejoyflight?id="+id;
        } else if (type == ActivityTypeEnum.PILOTTRAINING) {
            return "deletepilottraining?id="+id;
        } else {
            return null;
        }
    }

}
