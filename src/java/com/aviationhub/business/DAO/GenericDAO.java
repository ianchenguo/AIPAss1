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
 * A generic interface containing all database manipulating functions
 * @author ian
 * @param <T> specify a DAO type
 * @param <C> specify data type of a column
 */
public interface GenericDAO<T,C> {

    /**
     * Find all entries of a query
     * @return a list of DTOs 
     * @throws NamingException
     * @throws SQLException
     */
    public List<T> findAll() throws NamingException, SQLException;

    /**
     * Find one entry of a query
     * @param column
     * @return a DTO
     * @throws NamingException
     * @throws SQLException
     */
    public T findEntry(C column) throws NamingException, SQLException;

    /**
     * Add a new entry to a database table
     * @param rowDTO
     * @throws NamingException
     * @throws SQLException
     */
    public void addEntry(T rowDTO) throws NamingException, SQLException;

    /**
     * Delete an existed entry specified through a primary key
     * @param id
     * @throws NamingException
     * @throws SQLException
     */
    public void deleteEntry(Integer id) throws NamingException, SQLException;

    /**
     * Update a table entry
     * @param rowDTO
     * @throws NamingException
     * @throws SQLException
     */
    public void updateEntry(T rowDTO) throws NamingException, SQLException;
}
