import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class mainClass {
    public static void main(String[] args){
        System.setProperty("jdk.xml.entityExpansionLimit", "0");
        myPanel panel = new myPanel();
        myFrame frame= new myFrame(panel);
        frame.setLocationRelativeTo(null);
    }
}


