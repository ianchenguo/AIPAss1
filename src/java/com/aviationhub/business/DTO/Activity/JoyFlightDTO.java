/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DTO.Activity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author ian
 */
public class JoyFlightDTO extends ActivityDTO{
    @Max(50)
    @Min(1)
    private int capacity;
    
    public JoyFlightDTO() {
        type = ActivityTypeEnum.JOYFLIGHT;
                
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
