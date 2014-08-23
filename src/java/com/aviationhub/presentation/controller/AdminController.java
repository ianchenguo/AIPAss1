/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.presentation.controller;

import com.aviationhub.management.user.Administrator;
import com.aviationhub.management.user.UserDatabase;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ian
 */
@Named
@RequestScoped
//@SessionScoped
public class AdminController implements Serializable{
    private Administrator admin = new Administrator();
    
    /**
     * @return the admin
     */
    public Administrator getAdmin() {
        return admin;
    }

    public String login() {
        if (admin.getPassword().equals(UserDatabase.read(admin.getUserName()).getPassword())) {
            return "activitylist";
        } else {
            return "adminlogin";
        }
    }
    
    public String register() {
        UserDatabase.create(getAdmin());
        return "adminlogin";
    }

    
}
