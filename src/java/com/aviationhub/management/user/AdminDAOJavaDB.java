/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.management.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ian
 */
public class AdminDAOJavaDB implements Serializable, AdminDAO {

    private static final String JNDI_NAME = "jdbc/aip";
    private static final String SELECT_USER = "select username,password,fullname,employeeid,email "
            + "from aip.admin "
            + "where username=?";
    private static final String INSERT_USER = "insert into aip.admin(username,password,fullname,employeeid,email) "
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

    /**
     *
     *
     * @param username
     * @return
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    @Override
    public AdminDTO findUser(String username) throws NamingException, SQLException {
        try {
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                    PreparedStatement ps = conn.prepareStatement(SELECT_USER)) {
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
            }
        } catch (SQLException | NamingException e) {
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
    public void addUser(AdminDTO adminDTO) throws NamingException, SQLException {
        try {
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                    PreparedStatement ps = conn.prepareStatement(INSERT_USER)) {
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
            }
        } catch (SQLException | NamingException e) {
            throw e;
        }

    }
}
