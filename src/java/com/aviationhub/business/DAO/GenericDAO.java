/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ian
 * @param <T>
 */
public interface GenericDAO<T,C> {

    public List<T> findAll() throws NamingException, SQLException;

    public T findEntry(C column) throws NamingException, SQLException;

    public void addEntry(T rowDTO) throws NamingException, SQLException;

    public void deleteEntry(Integer id) throws NamingException, SQLException;

    public void updateEntry(T rowDTO) throws NamingException, SQLException;
}
