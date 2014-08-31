/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.activity.factory.ActivityDTO;
import com.aviationhub.business.activity.ActivityDatabase;
import com.aviationhub.business.activity.factory.ActivityTypeEnum;
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

    public Collection<ActivityDTO> getActivityList() {
        return ActivityDatabase.findAll();
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
