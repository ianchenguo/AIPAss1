/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.activity.factory;

/**
 *
 * @author ian
 */
public class SimpleActivityFactory {
    public ActivityDTO createActivity(ActivityTypeEnum type) {
        ActivityDTO activity = null;
        
        if (type == ActivityTypeEnum.JOYFLIGHT) {
            activity = new JoyFlightDTO();
        } else if (type == ActivityTypeEnum.PILOTTRAINING) {
            activity = new TrainingCourseDTO();
        }
        
        return activity;
    }
}
