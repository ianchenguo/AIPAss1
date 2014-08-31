/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.management.user;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ian
 */
public interface AdminDAO {
    public AdminDTO findUser(String username) throws NamingException,SQLException;
    public void addUser(AdminDTO adminDTO) throws NamingException, SQLException;
}
