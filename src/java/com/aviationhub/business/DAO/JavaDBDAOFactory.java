/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ian
 */
class JavaDBDAOFactory extends DAOFactory {

    private static final String JNDI_NAME = "jdbc/aip";

    public static DataSource createDataSource() throws NamingException, SQLException {
        try {
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            return ds;
        } catch (NamingException e) {
            throw e;
        }
    }

    @Override
    public JoyFlightDAO getJoyFlightDAO() {
        return new JavaDBJoyFlightDAO();
    }

    @Override
    public PilotTrainingDAO getPilotTrainingDAO() {
        return new JavaDBPilotTrainingDAO();
    }

    @Override
    public AdminDAO getAdminDAO() {
        return new JavaDBAdminDAO();
    }

}
