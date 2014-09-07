/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.DAO;

import com.aviationhub.business.DTO.Activity.ActivityDTO;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ian
 * @param <T>
 */
public interface ActivityDAO<T> {

    public List findAll() throws NamingException, SQLException;

    public ActivityDTO findActivity(Integer id) throws NamingException, SQLException;

    public void addActivity(T activityDTO) throws NamingException, SQLException;

    public void deleteActivity(Integer id) throws NamingException, SQLException;

    public void updateActivity(T activityDTO) throws NamingException, SQLException;
}
