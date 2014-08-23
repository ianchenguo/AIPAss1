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
public enum ActivityState {
    AVAILABLE("Available"),
    UPCOMING("Upcoming"),
    EXPIRED("Expired");
    
    private final String stateAsString;
    private ActivityState(String stateAsString) {
        this.stateAsString = stateAsString;
    }
    
    @Override
    public String toString(){
        return this.stateAsString;
    }
}
