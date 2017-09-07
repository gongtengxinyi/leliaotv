package com.dingjianlei.springboot.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 输出MD5
 *
 */
public class DigestUtil {

    public static String md5(String origin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger number = new BigInteger(1, md.digest(origin.getBytes()));
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(DigestUtil.md5("admin"));
    }
}
