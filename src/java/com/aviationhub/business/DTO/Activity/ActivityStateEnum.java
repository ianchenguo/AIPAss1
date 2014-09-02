/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DTO.Activity;

/**
 *
 * @author ian
 */
public enum ActivityStateEnum {
    AVAILABLE("Available"),
    UPCOMING("Upcoming"),
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
