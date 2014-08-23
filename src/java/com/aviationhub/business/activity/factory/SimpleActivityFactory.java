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
    public Activity createActivity(ActivityType type) {
        Activity activity = null;
        
        if (type == ActivityType.JOYFLIGHT) {
            activity = new JoyFlight();
        } else if (type == ActivityType.PILOTTRAINING) {
            activity = new TrainingCourse();
        }
        
        return activity;
    }
}
