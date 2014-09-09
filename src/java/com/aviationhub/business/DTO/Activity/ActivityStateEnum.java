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
public enum ActivityStateEnum {

    /**
     * available
     */
    AVAILABLE("Available"),

    /**
     * upcoming
     */
    UPCOMING("Upcoming"),

    /**
     * expired
     */
    EXPIRED("Expired");
    
    private final String stateAsString;
    private ActivityStateEnum (String stateAsString) {
        this.stateAsString = stateAsString;
    }
    
    @Override
    public String toString(){
        return this.stateAsString;
    }
}
