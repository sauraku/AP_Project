import GUI_Elements.myFrame;
import GUI_Elements.myPanel;
import queryHandlers.query1Handler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class mainClass {
    public static void main(String[] args){
        System.setProperty("jdk.xml.entityExpansionLimit", "0");
        try {
            File inputFile = new File("dblp.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            query1Handler userhandler = new query1Handler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
         myPanel panel = new myPanel();
        myFrame frame= new myFrame(panel);
        frame.setLocationRelativeTo(null);*/
    }
}


