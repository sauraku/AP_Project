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

    private boolean authorbool = false,ignorebool=false,overall=false,articlebool, titlebool = false, yearbool = false, urlbool = false,volumebool=false,pagebool=false,journalbool=false;
    private int sortby,from,to;
    private String name_title;
    int c=0;
    private publishables pub;
    private database d=new database();

    private JProgressBar bar;
    private JFrame loading;
    loadingScreen l;


    class loadingScreen
    {
        public loadingScreen()
        {
            loading= new JFrame();
            loading.setSize(500,200);
            bar = new JProgressBar(0, 1523384);
            bar.setValue(0);
            bar.setStringPainted(true);
            loading.add(bar);
        }
    }

    public query1aHandler(int _sortby,String _name_title,int _from,int _to)
    {
        sortby=_sortby;
        name_title=_name_title;
        from=_from;
        to=_to;
        l= new loadingScreen();
    }


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
            overall=false;
            articlebool=false;
            d.add(pub);
            ++c;
            if(c%1000000==0)
            {
                /*try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        public void run() {
                            // Remember to make pbar final variable.
                            bar.setValue(c);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }*/
            }
        }if (qName.equalsIgnoreCase("dblp")) {
            d.print();
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
            if(name_title.equals(temp))
            {
                overall = true;
                pub=new publishables();
                pub.setTitle(new String(ch, start, length));
            }
            authorbool = false;
        } else if (titlebool&& overall) {
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