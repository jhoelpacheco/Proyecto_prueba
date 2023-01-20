package prueba;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainPrueba2 {

  //private static final String FILENAME1 = "D:/eclipse-java-2022-09-R-win32-x86_64/M9Workspace/Proyecto_MiguelXML/staff.xml";
  private static final String FILENAME1 = "staff.xml";
	  
  private static final String FILENAME2 = "D:/eclipse-java-2022-09-R-win32-x86_64/M9Workspace/Proyecto_MiguelXML/subject.xml";
  
  public static void main(String[] args) {

      // Instantiate the Factory
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {

          // optional, but recommended
          // process XML securely, avoid attacks like XML External Entities (XXE)
          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

          // parse XML file
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME1));
          Document doc2 = db.parse(new File(FILENAME2));

          // optional, but recommended
          // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();

          System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
          System.out.println("------");

          // get <staff>
          NodeList list = doc.getElementsByTagName("teacher");
          NodeList list2 = doc2.getElementsByTagName("subject");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  // get teacher's id
                  String id = element.getAttribute("id");

                  // get teachers firstname & lastname
                  String firstname = element.getAttribute("fistname");
                  String lastname = element.getAttribute("lastname");
                  
                  

         
                  // print all
                  System.out.println("");
                  System.out.println("PROFE " + temp);
                  System.out.println("-------------------");
                  System.out.println("Teacher Id : " + id);
                  System.out.println("First Name : " + firstname);
                  System.out.println("Last Name : " + lastname);
                 

              }
          }
          
          for (int temp = 0; temp < list2.getLength(); temp++) {

              Node node = list2.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  // get subject id
                  String id = element.getAttribute("id");

                  // get subject name & short
                  String name = element.getAttribute("name");
                  String shortsubject = element.getAttribute("short");

         
                  // print all
                  System.out.println("");
                  System.out.println("SUBJECT " + temp);
                  System.out.println("-------------------");
                  System.out.println("Subject Id : " + id);
                  System.out.println("Name : " + name);
                  System.out.println("Short: " + shortsubject);

              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }

  }

}