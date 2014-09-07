/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.presentation.controller;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.ServletException;

/**
 *
 * @author ian
 */
@Named(value = "sideMenuController")
@Dependent
public class SideMenuController implements Serializable{

    /**
     * Creates a new instance of SideMenuController
     */
    public SideMenuController() {
    }
    
    @Inject AdminController adminController;
    public String logout() throws ServletException{
        
        return adminController.logout();
    }

    //setters and getters
    public AdminController getAdminController() {
        return adminController;
    }
    
    
}
