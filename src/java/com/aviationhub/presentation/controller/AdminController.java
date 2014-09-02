/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;


import com.aviationhub.business.DAO.AdminDAO;
import com.aviationhub.business.DAO.DAODBTypeEnum;
import com.aviationhub.business.DAO.DAOFactory;
import com.aviationhub.business.DTO.AdminDTO;
import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 *
 * @author ian
 */
@Named
@RequestScoped
//@SessionScoped
public class AdminController implements Serializable {

    private AdminDTO admin = new AdminDTO();
    private DAOFactory dAOFactory = DAOFactory.getFactory(DAODBTypeEnum.JAVADB);

    /**
     * @return the admin
     */
    public AdminDTO getAdmin() {
        return admin;
    }

    /**
     *
     * @return 
     * @throws NamingException
     * @throws SQLException
     */
    public String login() throws NamingException, SQLException {
        AdminDAO adminDAO = dAOFactory.getAdminDAO();
        AdminDTO adminDTO = adminDAO.findAccount(this.admin.getUsername());
        if (admin.getPassword().equals(adminDTO.getPassword())) {
            return "/faces/activitylist/activitylist?faces-redirect=true";
        } else {
            return "/faces/adminlogin/adminlogin?faces-redirect=true";
        }
    }

    /**
     *
     * @return 
     * @throws NamingException
     * @throws SQLException
     */
    public String register() throws NamingException, SQLException {
        AdminDAO adminDAO = dAOFactory.getAdminDAO();
        adminDAO.addAccount(admin);
        return "/faces/adminlogin/adminlogin?faces-redirect=true";
    }

}
