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
 *
 * @author ian
 */
public class AccountDTO implements Serializable{

    private int id;
    @Size(min = 3,max = 255)
    private String username;
    @Size(min = 6,max = 12)
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public AccountEnum getGroupname() {
        return groupname;
    }

    public void setGroupname(AccountEnum groupname) {
        this.groupname = groupname;
    }

}
