/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DTO.Account;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * A DTO class for account information
 * @author ian
 */
public class AccountDTO implements Serializable{

    private int id;
    @Size(min = 3,max = 255, message = "size of username must be between 3 and 255")
    private String username;
    @Size(min = 6,max = 20, message = "size of password must be between 6 and 20")
    private String password;
    @Size(max = 255)
    private String fullName;
    @Size(max = 255)
    private String employeeId;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}∼-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}∼-]+)*"
            + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Email format is invalid.")
    @Size(max = 255)
    private String email;
    private AccountEnum groupname;

    //getters and setters
    /**
     *
     * @return
     */
        public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     *
     * @return
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     *
     * @param employeeId
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public AccountEnum getGroupname() {
        return groupname;
    }

    /**
     *
     * @param groupname
     */
    public void setGroupname(AccountEnum groupname) {
        this.groupname = groupname;
    }

}
