/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;

import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * A concrete DAO factory for all types of DAOs used with JavaDB
 * @author ian
 */
class JavaDBDAOFactory extends DAOFactory {

    private static final String JNDI_NAME = "jdbc/aip";
    // this concrete factory takes care of database source creation
    public static DataSource createDataSource() throws NamingException, SQLException {
        try {
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            return ds;
        } catch (NamingException e) {
            throw e;
        }
    }

    @Override
    public GenericDAO getAdminDAO() {
        return new JavaDBAccountDAO();
    }

    @Override
    public GenericDAO getActivityDAO(ActivityTypeEnum type) {
        if (type == ActivityTypeEnum.JOYFLIGHT) {
            return new JavaDBJoyFlightDAO();
        } else if (type == ActivityTypeEnum.PILOTTRAINING) {
            return new JavaDBPilotTrainingDAO();
        } else {
            return null;
        }
    }
}
