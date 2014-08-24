/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.activity.ActivityDatabase;
import com.aviationhub.business.activity.factory.*;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ian
 */
@Named
//@SessionScoped
@RequestScoped
public class ActivityController implements Serializable {

    private Activity activity;
    private ActivityType activityType;

    /**
     * @return the activityType
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * @param activityType the activityType to set
     */
    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    /**
     * @return the activity
     */
    public Activity getActivity() {
        System.out.println("ACTIVITY IN ACTIVITY CONTROLLER IN GETACTIVITY: " + activity.getClass());
        return activity;
    }

    public String chooseActivityType() {
        if (activityType == ActivityType.JOYFLIGHT) {
            sessionScope 
            System.out.println("createjoyflight.xhtml?type=JOYFLIGHT");
            return "createjoyflight?faces-redirect=true&type=JOYFLIGHT";
        } else if (activityType == ActivityType.PILOTTRAINING) {
            return "createpilottraining.xhtml?faces-redirect=true&type=PILOTTRAINING";
        } else {
            return null;
        }
    }

    public void createActivity(ActivityType type) {
        //System.out.println("ENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //System.out.println("param test is: " + type);
        
        SimpleActivityFactory activityFactory = new SimpleActivityFactory();
        activity = activityFactory.createActivity(type);
        //System.out.println("ACTIVITY IN ACTIVITY CONTROLLER AFTER VIEWACTION: " + activity.getClass());
    }
    /*public void createActivity(ActivityType type) {
     System.out.println("ENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!TYPE IS:"+type);
     SimpleActivityFactory activityFactory = new SimpleActivityFactory();
     activity = activityFactory.createActivity(ActivityType.JOYFLIGHT);
     }*/

    public String saveActivity() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
        activityType = ActivityType.valueOf(params.get("type"));
        
        createActivity(activityType);
        System.out.println("ACTIVITY IN ACTIVITY CONTROLLER IN SAVEACTIVITY: " + activity.getClass());
        ActivityDatabase.create(this.activity);
        return "activitylist";
    }

    public String updateActivity() {
        ActivityDatabase.update(activity);
        return "activitylist";
    }

    public String deleteActivity() {
        ActivityDatabase.delete(activity.getId());
        return "activitylist";
    }

    public void loadActivity(int id) {
        //System.out.println("incoming id: "+id);
        activity = ActivityDatabase.read(id);
    }
}
