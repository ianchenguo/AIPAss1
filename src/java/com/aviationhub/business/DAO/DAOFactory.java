/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import java.io.Serializable;

/**
 * The top level abstract DAO factory class
 *
 * @author ian
 */
public abstract class DAOFactory implements Serializable {

    /**
     * An abstract method to get an adminDAO
     *
     * @return
     */
    public abstract GenericDAO getAdminDAO();

    /**
     * An abstract method to get an activityDAO, depending on selected activity type
     * @param type
     * @return
     */
    public abstract GenericDAO getActivityDAO(ActivityTypeEnum type);

    /**
     * Return a concrete DAO factory object
     * @param dbType
     * @return
     */
    public static DAOFactory getFactory(DBTypeEnum dbType) {
        switch (dbType) {
            case JAVADB:
                return new JavaDBDAOFactory();
            default:
                return null;
        }
    }
}
