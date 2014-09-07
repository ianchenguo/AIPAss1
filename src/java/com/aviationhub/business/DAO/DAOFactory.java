/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import java.io.Serializable;

/**
 * Abstract DAO factory class
 *
 * @author ian
 */
public abstract class DAOFactory implements Serializable {

    //abstract methods to get known DAO object
    public abstract AccountDAO getAdminDAO();

    public abstract ActivityDAO getActivityDAO(ActivityTypeEnum type);

    //return a concrete DAO factory object
    public static DAOFactory getFactory(DBTypeEnum dbType) {
        switch (dbType) {
            case JAVADB:
                return new JavaDBDAOFactory();
            default:
                return null;
        }
    }
}
