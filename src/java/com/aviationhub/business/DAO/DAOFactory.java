/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DAO;

/**
 * Abstract DAO factory class
 * @author ian
 */
public abstract class DAOFactory {
   
    //abstract methods to get knownDAO object
    public abstract AdminDAO getAdminDAO();
    public abstract JoyFlightDAO getJoyFlightDAO();
    public abstract PilotTrainingDAO getPilotTrainingDAO();
    
    //return a concrete DAO factory object
    public static DAOFactory getFactory(DAODBTypeEnum dbType) {
        switch(dbType) {
            case JAVADB:
                return new JavaDBDAOFactory();
            default:
                return null;
        }
    }
}
