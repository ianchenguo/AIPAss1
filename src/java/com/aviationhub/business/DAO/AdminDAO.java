/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.AdminDTO;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ian
 */
public interface AdminDAO {

    public List findAll() throws NamingException, SQLException;
    public AdminDTO findAccount(String username) throws NamingException, SQLException;
    public void addAccount(AdminDTO adminDTO) throws NamingException, SQLException;
    public void deleteAccount(Integer id) throws NamingException, SQLException;
    public void updateAccount(Integer id,AdminDTO adminDTO) throws NamingException, SQLException;

}
