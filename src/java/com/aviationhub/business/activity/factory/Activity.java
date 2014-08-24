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
public abstract class Activity {
    int id;
    String name;
    ActivityType type;
    ActivityState state;
    String provider;
    String aircraftInfo;
    String activityInfo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        System.out.println("ACTIVITY IN ACTIVITY CONTROLLER: " + this.getClass());
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public ActivityType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ActivityType type) {
        this.type = type;
    }

    /**
     * @return the state
     */
    public ActivityState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(ActivityState state) {
        this.state = state;
    }

    /**
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * @return the aircraftInfo
     */
    public String getAircraftInfo() {
        return aircraftInfo;
    }

    /**
     * @param aircraftInfo the aircraftInfo to set
     */
    public void setAircraftInfo(String aircraftInfo) {
        this.aircraftInfo = aircraftInfo;
    }

    /**
     * @return the activityInfo
     */
    public String getActivityInfo() {
        return activityInfo;
    }

    /**
     * @param activityInfo the activityInfo to set
     */
    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }
    
    
}
