/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Activity.ActivityDTO;
import com.aviationhub.business.DTO.Activity.ActivityStateEnum;
import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import com.aviationhub.business.DTO.Activity.JoyFlightDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ian
 */
class JavaDBJoyFlightDAO implements JoyFlightDAO {
    /*CREATE table AIP.ACTIVITY (
     ID          INTEGER NOT NULL 
     PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
     (START WITH 1, INCREMENT BY 1),
     TITLE       VARCHAR(255)NOT NULL, 
     TYPE        VARCHAR(255) NOT NULL,
     PROVIDER      VARCHAR(255) NOT NULL,
     AIRCRAFT     VARCHAR(255) NOT NULL,
     ACTIVITYSTATE   VARCHAR(255) NOT NULL,
     ACTIVITYDESC    VARCHAR(255) NOT NULL
     );


     CREATE TABLE AIP.PILOGTRAINING (
     ACTIVITYID  INTEGER NOT NULL 
     PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
     (START WITH 1, INCREMENT BY 1),
     CERTIFICATE    VARCHAR(255)NOT NULL,
     DURATION    VARCHAR(255)NOT NULL,
     FOREIGN KEY (ACTIVITYID)
     REFERENCES AIP.ACTIVITY(ID));

     CREATE TABLE AIP.JOYFLIGHT (
     ACTIVITYID  INTEGER NOT NULL 
     PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
     (START WITH 1, INCREMENT BY 1),
     CAPACITY    INTEGER NOT NULL,
     FOREIGN KEY (ACTIVITYID)
     REFERENCES AIP.ACTIVITY(ID));*/

    private static final String SELECT_ALL = "select id,title,activitytype,provider,aircraft,activitystate,activitydesc,capacity "
            + "from aip.activity, aip.joyflight "
            + "where aip.activity.id = aip.joyflight.activityid";
    
    
    private JoyFlightDTO createDTO(ResultSet rs) throws SQLException {
        
        JoyFlightDTO result = new JoyFlightDTO();
        result.setId(rs.getInt("id"));
        result.setName(rs.getString("title"));
        result.setType(ActivityTypeEnum.valueOf(rs.getString("activitytype")));
        result.setProvider(rs.getString("provider"));
        result.setAircraftInfo(rs.getString("aircraft"));
        result.setState(ActivityStateEnum.valueOf(rs.getString("activitystate")));
        result.setActivityInfo(rs.getString("activitydesc"));
        result.setCapacity(rs.getInt("capacity"));
        return result;
    }

    @Override
    public List findAll() throws NamingException, SQLException {

        List<JoyFlightDTO> results = new ArrayList<>();
        DataSource ds = JavaDBDAOFactory.createDataSource();

        try (Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SELECT_ALL)) {

            while (rs.next()) {
                results.add(createDTO(rs));
            }
        } catch (SQLException e) {
            throw e;
        }
        return results;
    }

    @Override
    public ActivityDTO findJoyFlight(Integer id) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addJoyFlight(ActivityDTO activityDTO) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteJoyFlight(Integer id) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateJoyFlight(Integer id, ActivityDTO activityDTO) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
