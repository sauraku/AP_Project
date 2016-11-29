package main_Class;

import GUI_Elements.myFrame;
import GUI_Elements.myPanel;
import utilities.parser;

/**
 * saurabh kumar 2015088
 * prashant 2015072
 */

///this is simply the main class
public class mainClass {
    public static void main(String[] args){
        System.setProperty("jdk.xml.entityExpansionLimit", "0");
        parser h = parser.getInstance();
        h.parse();
        myPanel panel = new myPanel();
        myFrame frame= new myFrame(panel);
        frame.setLocationRelativeTo(null);
    }
}


