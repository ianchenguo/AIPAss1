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
 */
public interface JoyFlightDAO {
    
    public List findAll() throws NamingException, SQLException;
    public ActivityDTO findJoyFlight(Integer id) throws NamingException, SQLException;
    public void addJoyFlight(ActivityDTO activityDTO) throws NamingException, SQLException;
    public void deleteJoyFlight(Integer id) throws NamingException, SQLException;
    public void updateJoyFlight(Integer id,ActivityDTO activityDTO) throws NamingException, SQLException;

}
