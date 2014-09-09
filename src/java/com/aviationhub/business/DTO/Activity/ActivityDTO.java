/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DTO.Activity;

import java.io.Serializable;
import javax.validation.constraints.Size;

/**
 * An abstract DTO class for all types of activities
 * @author ian
 */
public abstract class ActivityDTO implements Serializable{
    int id;
    @Size(max = 255)
    String name;
    ActivityTypeEnum type;
    ActivityStateEnum state;
    @Size(max = 255)
    String provider;
    @Size(max = 255)
    String aircraftInfo;
    @Size(max = 255)
    String activityInfo;

    //getters and setters
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
    public ActivityTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ActivityTypeEnum type) {
        this.type = type;
    }

    /**
     * @return the state
     */
    public ActivityStateEnum getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(ActivityStateEnum state) {
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
