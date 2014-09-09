/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DTO.Activity;

/**
 * An enum type defining known activity type
 * @author ian
 */
public enum ActivityTypeEnum {

    /**
     * pilot training
     */
    PILOTTRAINING("Pilot Training"),

    /**
     * joy flight
     */
    JOYFLIGHT("Joy Flight");
    
    private final String typeAsString;
    private ActivityTypeEnum(String typeAsString) {
        this.typeAsString = typeAsString;
    }
    
    @Override
    public String toString(){
        return this.typeAsString;
    }
}
