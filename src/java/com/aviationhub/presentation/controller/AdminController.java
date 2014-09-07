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
 *
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

    public boolean hasLoggedIn() {
        System.out.println("KICK IN!");
        HttpServletRequest request = getRequest();
        System.out.println("get request user: " + request.getRemoteUser());
        return request.getRemoteUser() != null;
    }

    /**
     *
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
            //login the account
            if (hasLoggedIn()) {
                logout();
            }
            request.login(admin.getUsername(), admin.getPassword());
            return "adminoperations/welcome?faces-redirect=true";

        } catch (ServletException e) {
            showError("Incorrect username or password");
            return null;
        }
    }

    /**
     * Logs out the current user of the container-managed authentication.
     *
     * @return an outcome corresponding to the login page
     * @throws ServletException if there is no currently logged in user
     */
    public String logout() throws ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.logout();
        return "logout";
    }

    /**
     *
     * @return @throws NamingException
     * @throws SQLException
     * @throws java.security.NoSuchAlgorithmException
     */
    public String register() throws NamingException, SQLException, NoSuchAlgorithmException {

        DAOFactory dAOFactory = DAOFactory.getFactory(DBTypeEnum.JAVADB);
        GenericDAO adminDAO = dAOFactory.getAdminDAO();

        try {
            admin.setPassword(Encryption.hash256(admin.getPassword()));
            adminDAO.addEntry(admin);
            return "index";
        } catch (NoSuchAlgorithmException | NamingException | SQLException e) {
            if (e.equals(e)) {

            }
            showError("Username or staff ID already exists");
            return null;
        }
    }

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
