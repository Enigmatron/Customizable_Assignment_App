//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.awt.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

//has a Alphabet-Number ceasar cipher; and has the ability to function with whitespaces and exclusionationary characters
public class FileHandler {
    private static final int key = 23;//0-36; with 0 and 36 being the original
    
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String FunctionSymbols = "-;:,";
    
    private static final File file = new File("C:\\ICStars\\unicorns.txt");
    private static ArrayList<String> content = null;
//        private static boolean loaded = false;

    public static boolean LoadFile() throws IOException{
        if(content == null){
//        String text = "";
//        if(file.exists())
        try{
            file.createNewFile();
        }
        catch(IOException e){
           
        }
        try {
            content = new ArrayList<String>(Files.readAllLines(file.toPath()));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

            return true;
        }
        return false;
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

            System.out.println(content.get(i).substring(startIndex, midIndex));
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
    private static void write(String text) throws IOException{
        try{
            ArrayList<String> fileContent = new ArrayList<String>(Files.readAllLines(file.toPath()));
            fileContent.add(text);
            Files.write(file.toPath(), fileContent);
        }
        finally{
            return;
        }
//        ArrayList<String> fileContent = new ArrayList<>(file.readAllLines());
        
    }

        
    
    private static void overwrite(String text, int index){
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
    }
     
     
    public static String encrypt( String text){
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
    public static String decrypt( String text){
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
    public static void main(String[] args) throws IOException{
        LoadFile();
        String test2 = getName();

//        String test = " tname:name:idries kysia;namenamenamename";
        System.out.println(test2);
//        test = FileHandler.encrypt(test);
        System.out.println(test2);
//        test = FileHandler.decrypt(test);
        System.out.println(test2);
//        test2 = getName(test2);
        System.out.println("name " + test2);
    }
}
