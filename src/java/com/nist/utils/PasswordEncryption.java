/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author shashi
 */
public class PasswordEncryption {
     public static String encryptedPassword(String inputValue) {
        String extra = "pass@#!&";
        String passWithExtra = inputValue + extra;
        String encryptedPass = null;
        if (inputValue == null) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passWithExtra.getBytes(), 0 , passWithExtra.length());
            encryptedPass = new BigInteger(1, md.digest()).toString(16);
            System.out.println("Password encrypted successfully");
        } catch (Exception e) {
            System.out.println("Error encrypting password");
        }
        return encryptedPass;
    }
   
}
