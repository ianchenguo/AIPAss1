/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Account.AccountDTO;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ian
 */
public interface AccountDAO {

    public List findAll() throws NamingException, SQLException;

    public AccountDTO findAccount(String username) throws NamingException, SQLException;

    public void addAccount(AccountDTO accountDTO) throws NamingException, SQLException;

    public void deleteAccount(Integer id) throws NamingException, SQLException;

    public void updateAccount(Integer id, AccountDTO accountDTO) throws NamingException, SQLException;

}
