/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DTO.Activity;


/**
 * A simple factory class to create specific type of activities
 * @author ian
 */
public class ActivityDTOSimpleFactory {

    /**
     * Create an activity DTO based on selected activity type
     * @param type
     * @return
     */
    public static ActivityDTO createActivity(ActivityTypeEnum type) {
 
        if (type == ActivityTypeEnum.JOYFLIGHT) {
            return new JoyFlightDTO();
        } else if (type == ActivityTypeEnum.PILOTTRAINING) {
            return new PilotTrainingDTO();
        } else {
            return null;
        }

    }
}
