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
    private ActivityDTO activity;
    private ActivityTypeEnum activityType;

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

    /**
     * @return the activity
     */
    public ActivityDTO getActivity() {
        return activity;
    }

    public String chooseType() {
        activity = activityFactory.createActivity(activityType);

        if (activityType == ActivityTypeEnum.JOYFLIGHT) {
            return "createjoyflight";
        } else {
            return "createpilottraining";
        }
    }

    public String createActivity() {
        ActivityDatabase.create(getActivity());
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
        activity = ActivityDatabase.read(id);
    }
}
