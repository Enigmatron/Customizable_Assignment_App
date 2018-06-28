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
        String sql = "INSERT INTO Test (id,size,firstCorrect, bestCorrect, firstDate,recentDate) " +"VALUES (" + id + "," + size + "," + correct + "," + correct + ",'" + load1 + "','" + load2 + "')";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home")+"/icstars/" + "mydatabase.db");
            stmt = c.createStatement();
//            try{
                stmt.executeUpdate(sql);
//                stmt.execute(sql);
//            }
//            catch(Exception e)
//            {
//
//            }
            stmt.close();
            c.close();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
    }
    public static void storeName(){
        
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

        return "";
    }
    public static String grabFirstSessionTimeFrom(int month, int date, int year){
        String command = "SELECT name FROM User";

        return "";
    }
    public static String grabSessionDate(int month, int date, int year){
        String command = "SELECT name FROM User";
        return "";
    }
    public static String grabName(){
        String command = "SELECT name FROM User";
        return "";
    }
    public static String grabTestTaken(){
        String command = "SELECT tests FROM User";
        return "";
    }
    public static String grabTestInfo(){
        return "";
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
//        System.out.println("database successfully created");
    }
}

/**
 * 
//        if(content == null){
////        String text = "";
////        if(file.exists())
//        try{
//            file.createNewFile();
//        }
//        catch(IOException e){
//           
//        }
//        try {
//            content = new ArrayList<String>(Files.readAllLines(file.toPath()));
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//
//            return true;
//        }
//        return false;
//        else{
//            System.out.println("not empty");
//            text = text.concat(":name: ;");
//            try{
//            PrintWriter out = new PrintWriter(file); 
//            
//            
////                File myFoo = new File("foo.log");
////FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
////                                                     // false to overwrite.
////fooWriter.write("New Contents\n");
////fooWriter.close();
//
//
////                FileWriter fw = new FileWriter(file);
////                fw.
////                fw.write(text);
////                fw.close();
//            }
//            catch (FileNotFoundException e){
//                
//            }
//            return text;
//        }
//        return FileHandler.getName(text);
        }
*/
    
    
    
    /** DEPRECATED: SQLite Update
    public static String getName() throws IOException{
        if(content != null){
            try{
            int startIndex = find("name");
//            System.out.println("search");

//            System.out.println("");
            if(startIndex != -1){
//                            System.out.println("found");

                String text = decrypt(content.get(startIndex));
                int index =  text.indexOf(":name:")+6;
                int end = text.indexOf(";",index);
                String ret = text.substring(index, end);

                StringBuilder titleCase = new StringBuilder();
                boolean nextTitleCase = true;

                for (char c : ret.toCharArray()) {
                    if (Character.isSpaceChar(c)) {
                        nextTitleCase = true;
                    } else if (nextTitleCase) {
                        c = Character.toTitleCase(c);
                        nextTitleCase = false;
                    }

                    titleCase.append(c);
                }

                return titleCase.toString();
            }
            else{
                return "";
            }
            }
            finally{
                
            }
        }
        return "Not Loaded";
    }
    
    //returns the line on the file
    private static int find(String query) throws IOException{
//        System.out.println("content Size " + content.size());

        for(int i = 0; i < content.size(); i++){
            int startIndex = content.get(i).indexOf(":");
//                    System.out.println("midIndex " + startIndex);
        

            int midIndex = content.get(i).indexOf(":", startIndex+1);
//                    System.out.println("midIndex " + midIndex);

//            System.out.println(content.get(i).substring(startIndex, midIndex));
            if(content.get(i).substring(startIndex, midIndex).contains(encrypt(query)))
                return i;
        }
        return -1;
    }
    
    
//    private static int findName() throws IOException{
//        try {
//            content.
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
        
//        if(loaded){
//        try{
//            ArrayList<String> fileContent = new ArrayList<String>(Files.readAllLines(file.toPath()));
//            for (int i = 0; i < fileContent.size(); i++) {
//                int startIndex = content.indexOf(":");
//                int midIndex = content.indexOf(":", startIndex);
//            if (fileContent.get(i).equals("old line")) {
//                fileContent.set(i, "new line");
//                break;
//            }
//        }
//            Files.write(file.toPath(), fileContent);
//        }
//        finally{
//            
//        }
//            int startIndex = content.indexOf(":");
//            int midIndex = content.indexOf(":", startIndex);
//
//            while(startIndex >-1){
//                String check = content.substring(startIndex, midIndex);
//                if(FileHandler.decrypt(content.substring(startIndex, midIndex)).contains("name"))
//                {
//                    return midIndex+1;
//                }
//                startIndex = content.indexOf(":", midIndex);
//                midIndex = content.indexOf(":", startIndex);
//            }
//        }
//        return -1;
//        int end = text.indexOf(";",startIndex);
//        String ret = text.substring(startIndex, end);
//
//        StringBuilder titleCase = new StringBuilder();
//        boolean nextTitleCase = true;
//
//        for (char c : ret.toCharArray()) {
//            if (Character.isSpaceChar(c)) {
//                nextTitleCase = true;
//            } else if (nextTitleCase) {
//                c = Character.toTitleCase(c);
//                nextTitleCase = false;
//            }
//
//            titleCase.append(c);
//        }
//        return titleCase.toString();
//    }
    
    
    //write by line that way you don't have to do as much work
    public static void write(String text){
        try {
            content.add(encrypt(text));
            Files.write(file.toPath(), content);
   
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

        
    
    public static void overwrite(String text, int index){
        try{
//            ArrayList<String> fileContent = new ArrayList<String>(Files.readAllLines(file.toPath()));
//            for (int i = 0; i < fileContent.size(); i++) {
//            if (fileContent.get(i).equals("old line")) {
//                fileContent.set(i, "new line");
//                break;
//            }
            content.set(index, text);

            Files.write(file.toPath(), content);
        }
        finally{
            return;
        }
//        List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
//
//for (int i = 0; i < fileContent.size(); i++) {
//    if (fileContent.get(i).equals("old line")) {
//        fileContent.set(i, "new line");
//        break;
//    }
//}
//
//Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
    }
    
    public static String setName(String text) throws IOException{
        if(content != null){
            try{
            int startIndex = find("name");
            if(startIndex!= -1){
                content.set(startIndex, encrypt(":name:"+text+";"));
                                        Files.write(file.toPath(), content);

                return "Replaced Name";
            }
            else{
                content.add(encrypt(":name:"+text+";"));
                                        Files.write(file.toPath(), content);

                return "Loaded Name";
            }

            }
            finally{
                return "NO FILE FOUND?";
            }
    }
    return "File Not Loaded";
        /**
//        int startIndex = text.indexOf(":name:") + 6;
//        int end = text.indexOf(";",startIndex);
//        String ret = text.substring(startIndex, end);
//
//        StringBuilder titleCase = new StringBuilder();
//        boolean nextTitleCase = true;
//
//        for (char c : ret.toCharArray()) {
//            if (Character.isSpaceChar(c)) {
//                nextTitleCase = true;
//            } else if (nextTitleCase) {
//                c = Character.toTitleCase(c);
//                nextTitleCase = false;
//            }
//
//            titleCase.append(c);
//        }
//        return titleCase.toString();
//}
*/

 /** SQLite Code
    Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.pr
    ////
    Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE COMPANY " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NAME           TEXT    NOT NULL, " + 
                        " AGE            INT     NOT NULL, " + 
                        " ADDRESS        CHAR(50), " + 
                        " SALARY         REAL)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
    
    ////
    
    Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                        "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                        "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
    
    */