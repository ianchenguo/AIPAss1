/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviationhub.business.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * An encryption class using SHA-256 algorithm, adapted from the tutorial instruction
 * Reference:
 * avilches 2010, 'How to encode a hex SHA256 in Java', 22 December, viewed 1 September 2014, <https://gist.github.com/avilches/750151>.
 * @author ian
 */
public class Encryption {

    public static String hash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte byt : bytes) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }
}
