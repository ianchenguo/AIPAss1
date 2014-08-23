/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.activity;

import com.aviationhub.business.activity.factory.Activity;
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
   
    private static LinkedHashMap<Integer, Activity> activityList = new LinkedHashMap<>();
   
    public static Collection<Activity> findAll() {
        return activityList.values();
    }
   
    public static void create(Activity activity) {
        activity.setId(generateUniqueId());
        activityList.put(activity.getId(), activity);
    }
   
    public static Activity read(int index) {
        return activityList.get(index);
    }
   
    public static void update(Activity activity) {
        activityList.put(activity.getId(), activity);
    }
   
    public static void delete(int index) {
        activityList.remove(index);
    }
}
