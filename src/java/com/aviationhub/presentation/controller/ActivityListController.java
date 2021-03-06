/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.activity.factory.Activity;
import com.aviationhub.business.activity.ActivityDatabase;
import com.aviationhub.business.activity.factory.ActivityType;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ian
 */
@Named
@RequestScoped
public class ActivityListController {

    public Collection<Activity> getActivityList() {
        return ActivityDatabase.findAll();
    }

    
    public String getTarget(String commandType, ActivityType type,int id) {
        
        if (type == ActivityType.JOYFLIGHT) {
            return commandType+"joyflight?faces-redirect=true&id="+id;
        } else if (type == ActivityType.PILOTTRAINING) {
            return commandType+"pilottraining?faces-redirect=true&id="+id;
        } else {
            return null;
        }
    }
}
