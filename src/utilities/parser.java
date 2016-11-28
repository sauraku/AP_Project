package utilities;

import Data.data;
import Data.publishables;
import GUI_Elements.loadingScreen;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by skwow on 11/8/2016.
 */
public class parser extends DefaultHandler
{
    private boolean authorbool = false,ignorebool=false,overall=false,articlebool, titlebool = false, yearbool = false, urlbool = false,volumebool=false,pagebool=false,journalbool=false;
    int c=0;
    private publishables pub;


    private loadingScreen ls;


    public parser()
    {
        System.setProperty("jdk.xml.entityExpansionLimit", "0");
        ls= new loadingScreen(1523384);
        try {
            File inputFile = new File("dblp.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(inputFile, this);
        } catch (Exception f) {
            f.printStackTrace();
        }    }


    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("article")) {
            articlebool = true;
        }else if (qName.equalsIgnoreCase("number")||qName.equalsIgnoreCase("ee")||qName.equalsIgnoreCase("crossref")||qName.equalsIgnoreCase("isbn")||qName.equalsIgnoreCase("publisher")||qName.equalsIgnoreCase("series")) {
            ignorebool = true;
        }
        else if (qName.equalsIgnoreCase("author")||qName.equalsIgnoreCase("editor")) {
            authorbool = true;
        } else if (qName.equalsIgnoreCase("title")||qName.equalsIgnoreCase("book")||qName.equalsIgnoreCase("www")||qName.equalsIgnoreCase("phdthesis")||qName.equalsIgnoreCase("inproceedings")||qName.equalsIgnoreCase("incollection")||qName.equalsIgnoreCase("proceedings")||qName.equalsIgnoreCase("mastersThesis")) {
            titlebool = true;
        }else if (qName.equalsIgnoreCase("pages")) {
            pagebool = true;
        }else if (qName.equalsIgnoreCase("year")) {
            yearbool = true;
        }else if (qName.equalsIgnoreCase("volume")) {
            volumebool = true;
        }else if (qName.equalsIgnoreCase("journal")||qName.equalsIgnoreCase("booktitle")) {
            journalbool = true;
        } else if (qName.equalsIgnoreCase("url")) {
            urlbool = true;
        }else if (qName.equalsIgnoreCase("dblp")) {
            //loading.setVisible(true);
        }
        else {
            ignorebool=true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("article")) {
            if(overall)
            {
                data.getAllData().add(pub);
                overall=false;
            }
            articlebool=false;
            ++c;
            if(c%10000==0)
            {
                ls.getBar().setValue(c);
                System.out.println((c/15233.94)+" %");
            }
        }if (qName.equalsIgnoreCase("dblp")) {
            System.out.println("100 % "+ data.getAllData().size());
            ls.getLoading().dispose();

        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (ignorebool)
        {
            ignorebool=false;
            return;
        }
        if (authorbool && articlebool) {
            String temp=new String(ch, start, length);
            overall = true;
            pub=new publishables();
            pub.addAuthor(new String(ch, start, length));
            authorbool = false;
        } else if (authorbool&& overall) {
            pub.addAuthor(new String(ch, start, length));
            // System.out.println("Title: " + new String(ch, start, length));
        }else if (titlebool&& overall) {
            titlebool = false;
            pub.setTitle(new String(ch, start, length));
            // System.out.println("Title: " + new String(ch, start, length));
        }else if (pagebool&& overall) {
            pagebool = false;
            pub.setPages(new String(ch, start, length));
            //System.out.println("pages: " + new String(ch, start, length));
        } else if (yearbool&& overall) {
            yearbool = false;
            try{
                pub.setYear(Integer.parseInt(new String(ch, start, length)));
                // System.out.println("Year: " + Integer.parseInt(new String(ch, start, length)));
            }catch (Exception e){};


        }else if (volumebool&& overall) {
            volumebool = false;
            pub.setVolume(new String(ch, start, length));
            //System.out.println("volume: " + new String(ch, start, length));
        }else if (journalbool&& overall) {
            journalbool = false;
            pub.setJournal_booktitle(new String(ch, start, length));
            //System.out.println("journal: " + new String(ch, start, length));
        } else if (urlbool&& overall) {
            urlbool = false;
            pub.addUrl(new String(ch, start, length));
            //System.out.println("Url: " + new String(ch, start, length));
        }
    }



}
