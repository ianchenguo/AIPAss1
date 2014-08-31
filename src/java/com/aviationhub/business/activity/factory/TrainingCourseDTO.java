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
public class TrainingCourseDTO extends ActivityDTO{
    private String duration;
    private String certificationInfo;

    public TrainingCourseDTO() {
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
