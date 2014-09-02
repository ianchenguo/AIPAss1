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
import com.aviationhub.business.DTO.Activity.PilotTrainingDTO;
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
class JavaDBPilotTrainingDAO implements PilotTrainingDAO{
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

    private static final String SELECT_ALL = "select id,title,activitytype,provider,aircraft,activitystate,activitydesc,certificate,duration "
            + "from aip.activity, aip.pilottraining "
            + "where aip.activity.id = aip.pilottraining.activityid";
    
    
    private PilotTrainingDTO createDTO(ResultSet rs) throws SQLException {
        
        PilotTrainingDTO result = new PilotTrainingDTO();
        result.setId(rs.getInt("id"));
        result.setName(rs.getString("title"));
        result.setType(ActivityTypeEnum.valueOf(rs.getString("activitytype")));
        result.setProvider(rs.getString("provider"));
        result.setAircraftInfo(rs.getString("aircraft"));
        result.setState(ActivityStateEnum.valueOf(rs.getString("activitystate")));
        result.setActivityInfo(rs.getString("activitydesc"));
        result.setCertificationInfo(rs.getString("certificate"));
        result.setDuration(rs.getString("duration"));
        return result;
    }

    @Override
    public List findAll() throws NamingException, SQLException {

        List<PilotTrainingDTO> results = new ArrayList<>();
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
    public ActivityDTO findPilotTraining(Integer id) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPilotTraining(ActivityDTO activityDTO) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePilotTraining(Integer id) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePilotTraining(Integer id, ActivityDTO activityDTO) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
