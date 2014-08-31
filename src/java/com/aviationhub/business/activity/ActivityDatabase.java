/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.activity;

import com.aviationhub.business.activity.factory.ActivityDTO;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 *
 * @author ian
 */
public class ActivityDatabase implements Serializable{
     // Helper to generate unique identifiers
    private static int idGenerator;
    private static synchronized int generateUniqueId() {
        idGenerator++;
        return idGenerator;
    }
   
    private static LinkedHashMap<Integer, ActivityDTO> activityList = new LinkedHashMap<>();
   
    public static Collection<ActivityDTO> findAll() {
        return activityList.values();
    }
   
    public static void create(ActivityDTO activity) {
        activity.setId(generateUniqueId());
        activityList.put(activity.getId(), activity);
    }
   
    public static ActivityDTO read(int index) {
        return activityList.get(index);
    }
   
    public static void update(ActivityDTO activity) {
        activityList.put(activity.getId(), activity);
    }
   
    public static void delete(int index) {
        activityList.remove(index);
    }
}
