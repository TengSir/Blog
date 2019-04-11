package edu.hbuas.blog.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5 {
    public static void main(String[] args) {
        String password="123456";
        byte[]  bs=null;
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            bs=md.digest();
            System.out.println(Arrays.toString(bs));
            String p=new BigInteger(1,bs).toString(16);
            System.out.println(p);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
