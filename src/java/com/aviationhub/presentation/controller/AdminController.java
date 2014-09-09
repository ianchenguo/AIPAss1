/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.presentation.controller;

import com.aviationhub.business.DAO.DAOFactory;
import com.aviationhub.business.DAO.DBTypeEnum;
import com.aviationhub.business.DAO.GenericDAO;
import com.aviationhub.business.DTO.Account.AccountDTO;
import com.aviationhub.business.DTO.Account.AccountEnum;
import com.aviationhub.business.encryption.Encryption;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * A page controller for pages related to account management
 * @author ian
 */
@Named
@SessionScoped
public class AdminController implements Serializable {

    private final AccountDTO admin = new AccountDTO();

    //initialise private account object
    @PostConstruct
    void init() {
        admin.setGroupname(AccountEnum.ADMIN);
    }

    private HttpServletRequest getRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

    /**
     * Test if the current session has logged in
     * @return boolean
     */
    public boolean hasLoggedIn() {
        //System.out.println("KICK IN!");
        HttpServletRequest request = getRequest();
        //System.out.println("get request user: " + request.getRemoteUser());
        return request.getRemoteUser() != null;
    }

    /**
     * login current user
     * @return @throws NoSuchAlgorithmException
     */
    public String login() throws NoSuchAlgorithmException {
        //create a request local variable to invoke login method
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            //debug
            //System.out.println("before login remote user is: " + request.getRemoteUser());
            //System.out.println("I AM HER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //System.out.println(admin.getUsername());
            //System.out.println(admin.getPassword());
            //System.out.println(Encryption.hash256(admin.getPassword()));
            //if the current session has a user logged in, log the user out first
            if (hasLoggedIn()) {
                logout();
            }
            //login the account
            request.login(admin.getUsername(), admin.getPassword());
            return "welcome";

        } catch (ServletException e) {
            showError("Incorrect username or password");
            return null;
        }
    }

    /**
     * log out the user
     * @return navigate to the login page
     * @throws ServletException
     */
    public String logout() throws ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.logout();
        return "logout";
    }

    /**
     * register a new user
     * @return navigate to staff login page
     * @throws NamingException
     * @throws SQLException if the user exists
     * @throws java.security.NoSuchAlgorithmException
     */
    public String register() throws NamingException, SQLException, NoSuchAlgorithmException {

        DAOFactory dAOFactory = DAOFactory.getFactory(DBTypeEnum.JAVADB);
        GenericDAO adminDAO = dAOFactory.getAdminDAO();

        try {
            admin.setPassword(Encryption.hash256(admin.getPassword()));
            adminDAO.addEntry(admin);
            return "stafflogin";
        } catch (NoSuchAlgorithmException | NamingException | SQLException e) {
            if (e.equals(e)) {

            }
            showError("Username or staff ID already exists");
            return null;
        }
    }

    //a show-error method adapted from week 4 tutorial examples
    private void showError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    //getters and setters
    /**
     *
     * @return
     */
    public AccountDTO getAdmin() {
        return admin;
    }

}
