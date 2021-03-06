/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.activity.ActivityDatabase;
import com.aviationhub.business.activity.factory.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ian
 */
@Named
@SessionScoped
public class ActivityController implements Serializable {

    private SimpleActivityFactory activityFactory = new SimpleActivityFactory();
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
        return activity;
    }

    public String chooseType() {
        activity = activityFactory.createActivity(activityType);

        if (activityType == ActivityType.JOYFLIGHT) {
            return "createjoyflight?faces-redirect=true";
        } else {
            return "createpilottraining?faces-redirect=true";
        }
    }

    public String createActivity() {
        ActivityDatabase.create(getActivity());
        return "activitylist?faces-redirect=true";
    }
    
    public String updateActivity() {
        ActivityDatabase.update(activity);
        return "activitylist?faces-redirect=true";
    }

    
    public String deleteActivity() {
        ActivityDatabase.delete(activity.getId());
        return "activitylist?faces-redirect=true";
    }

    public void loadActivity(int id) {
        System.out.println("LOADACTIVITY");
        activity = ActivityDatabase.read(id);
    }
}
