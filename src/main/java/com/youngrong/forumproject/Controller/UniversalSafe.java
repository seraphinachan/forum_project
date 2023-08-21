package com.youngrong.forumproject.BoardController;
import java.time.*;
import java.util.logging.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;


public class UniversalSafe {
    private static class recovery {
        String mail;
        String uuid;
    }
    private static String Username;
    /*This will be the primary key for manipulation via ODBC*/
    private static String uuid;
    private static String password;
    private static recovery recoveryTable;
    private static LocalDate regdate;
    private static boolean isAdmin;
    public static String getUsername() {
        return Username;
    }
    public static void saveUserName(String Mail, String User, String PW) {
        String sha512String = null;
        Logger logger = Logger.getLogger("com.youngrong.forumproject");
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-512");
            mDigest.reset();
            mDigest.update(User.getBytes());
            sha512String = String.format("%0128x", new BigInteger(1,mDigest.digest()));
            Username = sha512String;
            logger.info("Encrypted String is here:   "+ Username+"\n");
            mDigest.update(Mail.getBytes());
            sha512String = String.format("%0128x", new BigInteger(1,mDigest.digest()));
            recoveryTable.mail = sha512String;
            logger.info("Encrypted String is here: %s    "+ Username+"\n");
            mDigest.update(PW.getBytes());
            sha512String = String.format("%0128x", new BigInteger(1,mDigest.digest()));
            uuid = UUID.randomUUID().toString();
            recoveryTable.uuid =  UUID.randomUUID().toString();
        } catch (Exception e) {
            e.printStackTrace();
            storeError(e);
        }
        /** TODO: Implementation for UUID duplication check */
        /** TODO: Implementation for MySQL ODBC */


    }




    public static checkForErr export;
    private static boolean errorStat = false;
    private static Exception storedError = null;
    public static boolean isError() {
        return errorStat;
    }
    public static Exception getExceptionClass() {
        if(isError()) {
            export.e = storedError;
            export.err = true;
        } else {
                export.err=false;
        }
        return export.e;
    }
    public static void storeError(Exception e) {
            errorStat = true;
            storedError = e;
    }

}
