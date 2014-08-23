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
public enum ActivityType {
    PILOTTRAINING("Pilot training"),
    JOYFLIGHT("Joy flight");
    
    private final String typeAsString;
    private ActivityType(String typeAsString) {
        this.typeAsString = typeAsString;
    }
    
    @Override
    public String toString(){
        return this.typeAsString;
    }
}
