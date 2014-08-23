/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.management.user;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 *
 * @author ian
 */
public class UserDatabase implements Serializable {

    private static LinkedHashMap<String, Administrator> admins = new LinkedHashMap<>();

    private static int idGenerator;

    private static synchronized int generateUniqueId() {
        idGenerator++;
        return idGenerator;
    }

    public static void create(Administrator admin) {
        admin.setId(generateUniqueId());
        admins.put(admin.getUserName(), admin);
    }

    public static Administrator read(String userName) {
        return admins.get(userName);
    }
}

/*
 public class WaitingListDatabase implements Serializable {

 // Helper to generate unique identifiers
 private static int idGenerator;
 private static synchronized int generateUniqueId() {
 idGenerator++;
 return idGenerator;
 }
   
 private static LinkedHashMap<Integer, Group> groups = new LinkedHashMap<>();
   
 public static Collection<Group> findAll() {
 return groups.values();
 }
   
 public static void create(Group group) {
 group.setId(generateUniqueId());
 groups.put(group.getId(), group);
 }
   
 public static Group read(int index) {
 return groups.get(index);
 }
   
 public static void update(Group group) {
 groups.put(group.getId(), group);
 }
   
 public static void delete(int index) {
 groups.remove(index);
 }
   
 }

 */
