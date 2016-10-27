import GUI_Elements.myFrame;
import GUI_Elements.myPanel;

public class mainClass {
    public static void main(String[] args){

        /*try {
            File inputFile = new File("dblps.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
         myPanel panel = new myPanel();
        myFrame frame= new myFrame(panel);
        frame.setLocationRelativeTo(null);
    }
}


