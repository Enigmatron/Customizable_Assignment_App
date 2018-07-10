/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


import java.lang.StringBuilder;

import java.net.URI;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author idrieskysia
 */

/*
try {
         File inputFile = new File("input.txt");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("student");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Student roll no : " 
                  + eElement.getAttribute("rollno"));
               System.out.println("First Name : " 
                  + eElement
                  .getElementsByTagName("firstname")
                  .item(0)
                  .getTextContent());
               System.out.println("Last Name : " 
                  + eElement
                  .getElementsByTagName("lastname")
                  .item(0)
                  .getTextContent());
               System.out.println("Nick Name : " 
                  + eElement
                  .getElementsByTagName("nickname")
                  .item(0)
                  .getTextContent());
               System.out.println("Marks : " 
                  + eElement
                  .getElementsByTagName("marks")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
*/



/*
//make it a SAX parser
public class XMLParser extends DefaultHandler{
    private final static String testResourcePath = "/assets/QuestionGenerator/tests";
    private final static String lessonResourcePath = "/assets/QuestionGenerator/lessons";
    private static ArrayList<String> html;
//    boolean bQuestion = false;
   boolean bDescription = false;
   boolean bLine = false;
   boolean bWord = false;
//   int lineCount = 0;
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
         html.add("");
         bDescription = false;
      } else if (bLine) {  
         html.add("");  
         bLine = false;
      } else if (bWord) {
         html.add("");
         bWord = false;
      }   
   }
}
*/

public class XMLParser{
    private final static String testResourcePath = "/assets/QuestionGenerator/tests/";
    private final static String lessonResourcePath = "/assets/QuestionGenerator/lessons/";
    
    
    
    public TestQuestion parse(String subURI){
        TestQuestion tq = new TestQuestion();
        int QNo=0;
        ArrayList<Boolean> answer = new ArrayList<Boolean>();
        StringBuilder html = new StringBuilder();
        int elementCount = 0;
        int currentLineCount = 0;
        boolean lineAnswer = false;
        try {
            
            
         File inputFile;
         URL temp = getClass().getResource("/assets/QuestionGenerator/tests/" + subURI);
            inputFile = new File(temp.toURI());
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         
         
         
         NodeList nList = doc.getElementsByTagName("question");
         for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                QNo = Integer.parseInt(eElement.getAttribute("no"));
                html.append(eElement.getElementsByTagName("description").item(0).getTextContent());
                NodeList nList2 = nNode.getChildNodes();
                for(int j=0; j< nList2.getLength();j++){
                    System.out.println("entered question");

                    elementCount++;
                    currentLineCount=elementCount;
                    
                    Node nNode2 = nList2.item(i);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement2 = (Element) nNode2;
                        
                    }
                    NodeList nList3 = nNode2.getChildNodes();
                    for(int k=0; k< nList3.getLength();k++){
                        System.out.println("entered line");
                        Node nNode3 = nList3.item(k);
                        if(nNode3.getNodeName().equals("word")){
                            elementCount++;
                            html.append("<td class=\"mutable\" id=\""
                                    + elementCount
                                    +"\" "
                                    + "onclick=\"test()\">");
                            html.append(eElement.getElementsByTagName("word").item(0).getTextContent());
                            html.append("</td>");

                        }
                        if(nNode3.getNodeName().equals("error")){
                            elementCount++;
                            if(!lineAnswer){
                                lineAnswer = true;
                                answer.set(currentLineCount, true);
                            }
                            html.append("<td class=\"mutable\" id=\""
                                    + elementCount
                                    +"\" "
                                    + "onclick=\"test()\">");
                            html.append(eElement.getElementsByTagName("error").item(0).getTextContent());
                            html.append("</td>");
                        }
                        if(nNode3.getNodeName().equals("edict")){
                            elementCount++;
                            html.append("<td class=\"\""
                                        + "onclick=\"test()\">");
                            html.append(eElement.getElementsByTagName("edict").item(0).getTextContent());                            
                            html.append("</td>");

                        }
                    }
                }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
        
        tq.html=html.toString();
        return tq;
    }
    
    public static void main(String[] args){
        XMLParser par = new XMLParser();
        TestQuestion tq = par.parse("ExampleTest.xsd");
        System.out.println(tq.html);
        
    }
    
    
    
}

