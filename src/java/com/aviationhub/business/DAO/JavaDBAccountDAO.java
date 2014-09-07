/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Account.AccountDTO;
import java.io.Serializable;
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
class JavaDBAccountDAO implements Serializable,GenericDAO<AccountDTO,String> {

    private static final String SELECT_ADMIN = "select username,groupname,password,fullname,employeeid,email "
            + "from aip.account "
            + "where username=?"
            + "and groupname='ADMIN'";
    private static final String INSERT_ACCOUNT = "insert into aip.account(username,groupname,password,fullname,employeeid,email) "
            + "values(?,?,?,?,?,?)";

    private AccountDTO createDTO(ResultSet rs) throws SQLException {
        AccountDTO result = new AccountDTO();
        result.setUsername(rs.getString("username"));
        result.setUsername(rs.getString("groupname"));
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

    


    @Override
    public AccountDTO findEntry(String username) throws NamingException, SQLException {
        DataSource ds = JavaDBDAOFactory.createDataSource();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(SELECT_ADMIN)) {
            //populate the binding variable
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("I FOUND A ROW!!!!!!!!!!!!!!!!!!!!!!!!!");
                    // if find the user
                    return createDTO(rs);
                } else {
                    // if cannot find the user
                    System.out.println("I DIDN'T FIND A ROW!!!!!!!!!!!!!!!!!!!!!!!!!");
                    return null;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void addEntry(AccountDTO accountDTO) throws NamingException, SQLException {
         DataSource ds = JavaDBDAOFactory.createDataSource();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_ACCOUNT)) {
            conn.setAutoCommit(false);
            //populate the binding variable
            ps.setString(1, accountDTO.getUsername());
            ps.setString(2, accountDTO.getGroupname().name());
            ps.setString(3, accountDTO.getPassword());
            ps.setString(4, accountDTO.getFullName());
            ps.setString(5, accountDTO.getEmployeeId());
            ps.setString(6, accountDTO.getEmail());
            //execute the insertion
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void deleteEntry(Integer id) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEntry(AccountDTO accountDTO) throws NamingException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
