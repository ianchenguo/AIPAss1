/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.management.user.AdminDAO;
import com.aviationhub.management.user.AdminDAOJavaDB;
import com.aviationhub.management.user.AdminDTO;
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

    /**
     * @return the admin
     */
    public AdminDTO getAdmin() {
        return admin;
    }

    public String login() throws NamingException, SQLException {

        AdminDAO adminDAO = new AdminDAOJavaDB();
        AdminDTO adminDTO = adminDAO.findUser(this.admin.getUsername());
        if (admin.getPassword().equals(adminDTO.getPassword())) {
            return "activitylist?faces-redirect=true";
        } else {
            return "adminlogin?faces-redirect=true";
        }
    }

    public String register() throws NamingException, SQLException {
        AdminDAO adminDAO = new AdminDAOJavaDB();
        adminDAO.addUser(admin);
        return "adminlogin?faces-redirect=true";
    }

}
