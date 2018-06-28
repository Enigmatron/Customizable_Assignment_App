//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import java.sql.*;
import java.awt.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

//has a Alphabet-Number ceasar cipher; and has the ability to function with whitespaces and exclusionationary characters
public class FileHandler {   
    //Database Creation Variables
    private static final File file = new File(System.getProperty("user.home")+"/icstars/");
    private static Statement stmt = null;
    private static Connection c = null;
    private static final String userData = "CREATE TABLE User"+
        "(name TEXT PRIMARY KEY ," +
        " logins INTEGER NOT NULL, " +
        " tests INTEGER NOT NULL) ";

    private static final String loginData = "CREATE TABLE Login"+
        "(date TEXT PRIMARY KEY ," +
        "firstLogin TEXT ," +
        "recentLogin TEXT, " +
        "logins INTEGER) ";
    private static final String testData = "CREATE TABLE Test"+
        "(id INTEGER PRIMARY KEY," +
        " size INTEGER, " +
        " firstCorrect INTEGER, " +
        " bestCorrect INTEGER, " +
        " taken INTEGER, " +
        " firstDate TEXT NOT NULL, " +
        " recentDate TEXT NOT NULL ) " ;
    private static final Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public static boolean initialize() throws IOException{
        c = null;

        try {
            
            file.mkdir();
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
            stmt = c.createStatement();
            try{
            stmt.execute(testData);
            }
            catch ( Exception e ) {
                
            }
            try{
            stmt.execute(userData);
            }
            catch ( Exception e ) {
                
            }
            try{
            stmt.execute(loginData);
            }
            catch ( Exception e ) {
            
            }

            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        return false;

        }
        System.out.println("database successfully created");
        return true;
    }
    public static void storeTest(int id, int size, int correct){
        SimpleDateFormat Date = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat Time = new SimpleDateFormat("HH:mm.ss");

        String load1 = Date.format(Timestamp.from(timestamp.toInstant()));
        String load2 = Time.format(Timestamp.from(timestamp.toInstant()));
//        System.out.println(lo)
        String sql = "INSERT INTO Test (id,size,firstCorrect, bestCorrect,taken, firstDate,recentDate) " +"VALUES (" + id + "," + size + "," + correct + "," + correct +", "+ 1 + ",'" + load1 + "','" + load2 + "')";
        String sql2 = "UPDATE Test SET taken = taken + 1, recentDate = '"+ load1 + "' WHERE id = " + id + ";";

        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
            stmt = c.createStatement();
            try{
                stmt.executeUpdate(sql);
            }
            catch(Exception e){
//                stmt.executeUpdate(sql2);

                System.err.println( e.getClass().getName() + ": " + e.getMessage() );

            }
            finally{
                stmt.executeUpdate(sql2);
            }
            
            stmt.close();
            c.close();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
    }
    public static void storeName(){
        String sql = "INSERT INTO User (name,logins,tests) " +"VALUES ('" + "idries" + "'," + 12 + ",'" + "hi" + "')";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
            stmt = c.createStatement();
            try{
                stmt.executeUpdate(sql);
            }
            catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            stmt.close();
            c.close();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
    }
    public static void storeSessionDate(){
//        Timestamp ts = new Timestamp();
//        Date date = new Date();
//        date.setTime(ts.getTime());
        SimpleDateFormat Date = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat Time = new SimpleDateFormat("HH:mm.ss");

        String load1 = Date.format(Timestamp.from(timestamp.toInstant()));
        String load2 = Time.format(Timestamp.from(timestamp.toInstant()));

        
        
        String updateUserInfo = "UPDATE User SET name = SELECT COUNT(*) FROM Login;";
    }
    public static String grabLastSessionTimeFrom(int month, int date, int year){
        String command = "SELECT name FROM User";
        String ret = "";
        try{
                   Class.forName("org.sqlite.JDBC");
                   Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
                   stmt = c.createStatement();
                   try{
                       ResultSet rs = stmt.executeQuery("SELECT * FROM User;");
                       ret = rs.getString("name");
//                       stmt.executeUpdate(command);
                   }
                   catch(Exception e){
                       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                   }
                   stmt.close();
                   c.close();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
        return ret;
    }
    public static String grabFirstSessionTimeFrom(int month, int date, int year){
        String command = "SELECT name FROM User";

        return "";
    }
    public static String grabSessionDate(int month, int date, int year){
        SimpleDateFormat Date = new SimpleDateFormat("MM-dd-yyyy");

        String command = "SELECT name FROM User";
        return "";
    }
    public static String grabName(){
        String command = "SELECT * FROM User;";
        String ret = "";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
            stmt = c.createStatement();
            try{
                ResultSet rs = stmt.executeQuery(command);
                ret = rs.getString("name");
                rs.close();
//                       stmt.executeUpdate(command);
            }
            catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            stmt.close();
            c.close();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
        return ret;
    }
    public static int grabTestTaken(){
        String command = "SELECT * FROM User";
        int ret = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
            stmt = c.createStatement();
            try{
                ResultSet rs = stmt.executeQuery(command);
                ret = rs.getInt("tests");
                rs.close();
//                       stmt.executeUpdate(command);
            }
            catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            stmt.close();
            c.close();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
        return ret;
    }
    public static ResultSet grabTestInfo(int id){
        String command = "SELECT * FROM Test";
        ResultSet ret = null;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
            stmt = c.createStatement();
            try{
                ret = stmt.executeQuery(command);
                ret.close();
            }
            catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            stmt.close();
            c.close();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
        return ret;
    }
    
    public static class Encrypter{
        private static final int key = 23;//0-36; with 0 and 36 being the original
        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
        private static final String FunctionSymbols = "-;:,.";  
        private static String encrypt( String text){
    //        System.out.println("Enter");

            text = text.toLowerCase();
            String cipherText = "";
            for (int i = 0; i < text.length(); i++)
            {
    //            System.out.println("Running");
                if(Character.isWhitespace(text.charAt(i))){
                    cipherText += " ";
                    continue;
                }
                if(FunctionSymbols.indexOf(text.charAt(i)) != -1){
                    cipherText += text.charAt(i);
                    continue;
                }
                int charPosition = ALPHABET.indexOf(text.charAt(i));
                int keyVal = (key + charPosition) % 36;
                char replaceVal = ALPHABET.charAt(keyVal);
                cipherText += replaceVal;
            }
            return cipherText;
        }
        private static String decrypt( String text){
        text = text.toLowerCase();
        String plainText = "";
        for (int i = 0; i < text.length(); i++)
        {
            if(Character.isWhitespace(text.charAt(i))){
                plainText += " ";
                continue;
            }
            if(FunctionSymbols.indexOf(text.charAt(i)) != -1){
                plainText += text.charAt(i);
                continue;
            }
            int charPosition = ALPHABET.indexOf(text.charAt(i));
            int keyVal = (charPosition - key) % 36;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
    }
    
    
    public static void main(String[] args) throws IOException{
        initialize();
        storeTest(0, 1, 10);  
        storeName();
        System.out.println(grabName());
    }
}

