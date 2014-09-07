/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Activity.ActivityDTO;
import com.aviationhub.business.DTO.Activity.ActivityStateEnum;
import com.aviationhub.business.DTO.Activity.ActivityTypeEnum;
import com.aviationhub.business.DTO.Activity.PilotTrainingDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ian
 */
class JavaDBPilotTrainingDAO implements Serializable, ActivityDAO<PilotTrainingDTO> {

    private static final String SELECT_ALL = "select activity.id,title,activitytype,provider,aircraft,activitystate,activitydesc,certificate,duration "
            + "from aip.activity, aip.pilottraining "
            + "where aip.activity.id = aip.pilottraining.activityid";

    private static final String SELECT_BY_KEY = "select activity.id,title,activitytype,provider,aircraft,activitystate,activitydesc,certificate,duration "
            + "from aip.activity, aip.pilottraining "
            + "where aip.activity.id = aip.pilottraining.activityid "
            + "and activity.id = ?";

    private static final String INSERT_INTO_PARENT_TABLE = "insert into aip.activity(title,activitytype,provider,aircraft,activitystate,activitydesc) "
            + "values(?,?,?,?,?,?)";

    private static final String INSERT_CHILD_TABLE = "insert into aip.pilottraining(activityid,certificate,duration) values (?,?,?)";

    private static final String DELETE_BY_KEY = "delete from aip.activity where id = ?";

    private static final String UPDATE_PARENT_TABLE = "update aip.activity "
            + "set title = ?,activitytype = ?,provider = ?,aircraft = ?,activitystate = ?,activitydesc = ? "
            + "where id = ?";

    private static final String UPDATE_CHILD_TABLE = "update aip.pilottraining "
            + "set certificate = ? ,duration = ?"
            + "where activityid = ?";

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
    public ActivityDTO findActivity(Integer id) throws NamingException, SQLException {

        DataSource ds = JavaDBDAOFactory.createDataSource();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(SELECT_BY_KEY)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return createDTO(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void addActivity(PilotTrainingDTO activityDTO) throws NamingException, SQLException {
        DataSource ds = JavaDBDAOFactory.createDataSource();
        int activityID = 0;
        try (Connection conn = ds.getConnection();
                PreparedStatement ps1 = conn.prepareStatement(INSERT_INTO_PARENT_TABLE, RETURN_GENERATED_KEYS);
                PreparedStatement ps2 = conn.prepareStatement(INSERT_CHILD_TABLE, RETURN_GENERATED_KEYS)) {
            //insert into the parent table
            conn.setAutoCommit(false);
            ps1.setString(1, activityDTO.getName());
            ps1.setString(2, activityDTO.getType().name());
            ps1.setString(3, activityDTO.getProvider());
            ps1.setString(4, activityDTO.getAircraftInfo());
            ps1.setString(5, activityDTO.getState().name());
            ps1.setString(6, activityDTO.getActivityInfo());
            ps1.executeUpdate();
            //get the foreign key value
            try (ResultSet keyResultSet = ps1.getGeneratedKeys()) {
                if (keyResultSet.next()) {
                    activityID = (int) keyResultSet.getInt(1);
                    System.out.println(activityID);
                }
            }
            //insert into the child table
            ps2.setInt(1, activityID);
            ps2.setString(2, activityDTO.getCertificationInfo());
            ps2.setString(3, activityDTO.getDuration());
            ps2.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void deleteActivity(Integer id) throws NamingException, SQLException {
        DataSource ds = JavaDBDAOFactory.createDataSource();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(DELETE_BY_KEY)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void updateActivity(PilotTrainingDTO activityDTO) throws NamingException, SQLException {
        DataSource ds = JavaDBDAOFactory.createDataSource();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps1 = conn.prepareStatement(UPDATE_PARENT_TABLE);
                PreparedStatement ps2 = conn.prepareStatement(UPDATE_CHILD_TABLE)) {
            //update the parent table
            conn.setAutoCommit(false);
            ps1.setString(1, activityDTO.getName());
            ps1.setString(2, activityDTO.getType().name());
            ps1.setString(3, activityDTO.getProvider());
            ps1.setString(4, activityDTO.getAircraftInfo());
            ps1.setString(5, activityDTO.getState().name());
            ps1.setString(6, activityDTO.getActivityInfo());
            ps1.setInt(7, activityDTO.getId());
            ps1.executeUpdate();
            //update the child table
            ps2.setString(1, activityDTO.getCertificationInfo());
            ps2.setString(2, activityDTO.getDuration());
            ps2.setInt(3, activityDTO.getId());
            ps2.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

}
