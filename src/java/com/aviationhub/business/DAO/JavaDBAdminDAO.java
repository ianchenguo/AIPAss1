/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.AdminDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ian
 */
class JavaDBAdminDAO implements AdminDAO {

    private static final String SELECT_ADMIN = "select username,password,fullname,employeeid,email "
            + "from aip.admin "
            + "where username=?";
    private static final String INSERT_ADMIN = "insert into aip.admin(username,password,fullname,employeeid,email) "
            + "values(?,?,?,?,?)";

    private AdminDTO createDTO(ResultSet rs) throws SQLException {
        AdminDTO result = new AdminDTO();
        result.setUsername(rs.getString("username"));
        result.setPassword(rs.getString("password"));
        result.setFullName(rs.getString("fullname"));
        result.setEmployeeId(rs.getString("employeeid"));
        result.setEmail(rs.getString("email"));
        return result;
    }

    @Override
    public List findAll() throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     *
     * @param username
     * @return
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    @Override
    public AdminDTO findAccount(String username) throws SQLException, NamingException {

        DataSource ds = JavaDBDAOFactory.createDataSource();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(SELECT_ADMIN)) {
            //populate the binding variable
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // if find the user
                    return createDTO(rs);
                } else {
                    // if cannot find the user
                    return null;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     *
     * @param adminDTO
     * @throws NamingException
     * @throws SQLException
     */
    @Override
    public void addAccount(AdminDTO adminDTO) throws NamingException, SQLException {

        DataSource ds = JavaDBDAOFactory.createDataSource();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_ADMIN)) {
            conn.setAutoCommit(false);
            //populate the binding variable
            ps.setString(1, adminDTO.getUsername());
            ps.setString(2, adminDTO.getPassword());
            ps.setString(3, adminDTO.getFullName());
            ps.setString(4, adminDTO.getEmployeeId());
            ps.setString(5, adminDTO.getEmail());
            //execute the insertion
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void deleteAccount(Integer id) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAccount(Integer id, AdminDTO activityDTO) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
