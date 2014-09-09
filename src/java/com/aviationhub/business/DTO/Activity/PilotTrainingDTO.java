/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DTO.Activity;

import javax.validation.constraints.Size;

/**
 * A concrete DTO for joy flight activities
 * @author ian
 */
public class PilotTrainingDTO extends ActivityDTO{
    @Size(max = 255)
    private String duration;
    @Size(max = 255)
    private String certificationInfo;

    /**
     * override the default constructor
     */
    public PilotTrainingDTO() {
        type = ActivityTypeEnum.PILOTTRAINING;
    }


    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the certificationInfo
     */
    public String getCertificationInfo() {
        return certificationInfo;
    }

    /**
     * @param certificationInfo the certificationInfo to set
     */
    public void setCertificationInfo(String certificationInfo) {
        this.certificationInfo = certificationInfo;
    }
}
