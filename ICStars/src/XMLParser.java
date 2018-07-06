/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.File;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *
 * @author idrieskysia
 */


//make it a SAX parser
public class XMLParser extends DefaultHandler{
    private final static String testResourcePath = "/assets/QuestionGenerator/tests";
    private final static String lessonResourcePath = "/assets/QuestionGenerator/lessons";
    
//    boolean bQuestion = false;
   boolean bDescription = false;
   boolean bLine = false;
   boolean bWord = false;
   int lineCount = 0;
    @Override
   public void startElement(String uri, 
   String localName, String qName, Attributes attributes) throws SAXException {

      if (qName.equalsIgnoreCase("question")) {
         String no = attributes.getValue("no");
         System.out.println("No : " + no);
      } 
//      else if (qName.equalsIgnoreCase("description")) {
//         bQuestion = true;
//      }
      else if (qName.equalsIgnoreCase("description")) {
         bDescription = true;
      } else if (qName.equalsIgnoreCase("line")) {
         bLine = true;
      }
      else if (qName.equalsIgnoreCase("word")) {
         bWord = true;
      }
   }

   @Override
   public void endElement(String uri, 
   String localName, String qName) throws SAXException {
      if (qName.equalsIgnoreCase("student")) {
         System.out.println("End Element :" + qName);
      }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {
      
      if (bDescription) {
         System.out.println("First Name: " 
            + new String(ch, start, length));
         bDescription = false;
      } else if (bLine) {
         System.out.println("Last Name: " + new String(ch, start, length));
         bLine = false;
      } else if (bWord) {
         System.out.println("Nick Name: " + new String(ch, start, length));
         bWord = false;
      } 
//      else if (bMarks) {
//         System.out.println("Marks: " + new String(ch, start, length));
//         bMarks = false;
//      }
   }
    
    
}
