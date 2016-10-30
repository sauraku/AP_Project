package queryHandlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by skwow on 10/27/2016.
 */
public class query3Handler extends DefaultHandler{
    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bNickName = false;
    boolean bMarks = false;
    int c=0;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("article")) {
            String modDate = attributes.getValue("mdate");
            //System.out.println("modified on : " + modDate);
        } else if (qName.equalsIgnoreCase("author")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("title")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("year")) {
            bNickName = true;
        } else if (qName.equalsIgnoreCase("url")) {
            bMarks = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("article")) {
            //System.out.println();
            ++c;
            if(c%1000==0)
            {
                System.out.println(c);
            }
        }
    }

    @Override
    public void characters(char ch[],
                           int start, int length) throws SAXException {
        if (bFirstName) {
            // System.out.println("Author: "+ new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            // System.out.println("Title: " + new String(ch, start, length));
            bLastName = false;
        } else if (bNickName) {
            // System.out.println("Year: " + new String(ch, start, length));
            bNickName = false;
        } else if (bMarks) {
            //  System.out.println("Url: " + new String(ch, start, length));
            bMarks = false;
        }
    }
}
