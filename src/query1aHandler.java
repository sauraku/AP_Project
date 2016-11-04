import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by skwow on 10/18/2016.
 *
 */


public class query1aHandler extends DefaultHandler {

    private boolean authorbool = false,overall=false,articlebool=false, titlebool = false, yearbool = false, urlbool = false,volumebool=false,pagebool=false,journalbool=false;
    private int sortby,from,to;
    private String name_title;
    int c=0;
    private publishables pub;
    private database d;

    public query1aHandler(int _sortby,String _name_title,int _from,int _to)
    {
        sortby=_sortby;
        name_title=_name_title;
        from=_from;
        to=_to;
        d= new database();
    }


    @Override
    public void startElement(String uri,String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("author")) {
            authorbool = true;
        } else if (qName.equalsIgnoreCase("title")||qName.equalsIgnoreCase("book")||qName.equalsIgnoreCase("www")||qName.equalsIgnoreCase("phdthesis")||qName.equalsIgnoreCase("inproceedings")||qName.equalsIgnoreCase("incollection")||qName.equalsIgnoreCase("proceedings")||qName.equalsIgnoreCase("mastersThesis")) {
            titlebool = true;
        }else if (qName.equalsIgnoreCase("pages")) {
            pagebool = true;
        }else if (qName.equalsIgnoreCase("volume")) {
            volumebool = true;
        }else if (qName.equalsIgnoreCase("journal")) {
            journalbool = true;
        }else if (qName.equalsIgnoreCase("article")) {
            articlebool = true;
        } else if (qName.equalsIgnoreCase("year")) {
            yearbool = true;
        } else if (qName.equalsIgnoreCase("url")) {
            urlbool = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("article")) {
            overall=false;
            articlebool=false;
            d.add(pub);
            ++c;
           /* if(c%1000000==0)
            {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // Remember to make pbar final variable.
                        myFrame.getBar().setValue(c);
                    }
                });
            }*/
        }else if (qName.equalsIgnoreCase("dblp")) {
            System.out.println("\n\n"+c+"     Done!");
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

         if (authorbool && articlebool) {
            String temp=new String(ch, start, length);
            if(name_title.equals(temp))
            {
                overall = true;
                pub=new publishables();
              //  pub.setTitle(new String(ch, start, length));
                //pub.addAuthor(temp);
            }
            authorbool = false;
        } else if (titlebool&& overall) {
           // pub.setTitle(new String(ch, start, length));
            titlebool = false;
        } else if (yearbool&& overall) {
             System.out.println(new String(ch, start, length));
             //pub.setYear(Integer.parseInt(new String(ch, start, length)));
             yearbool = false;
        } else if (urlbool&& overall) {
           //  pub.addUrl(new String(ch, start, length));
             urlbool = false;
        } else if (volumebool&& overall) {
            // pub.setVolume(new String(ch, start, length));
             volumebool = false;
        } else if (pagebool&& overall) {
             System.out.println("       "+new String(ch, start, length));
          //   pub.setPages(new String(ch, start, length));
             pagebool = false;
        } else if (journalbool&& overall) {
           //  pub.setJournal_booktitle(new String(ch, start, length));
             journalbool = false;
        }
    }
}