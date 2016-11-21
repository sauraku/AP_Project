import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by skwow on 10/18/2016.
 *
 */

//sortby 0== year 1==relevence
public class query1Handler  {

    private int sortby,from,to;
    private String name_title;
    private ArrayList<publishables> list= new ArrayList<>();

    public query1Handler(String _name_title, int _sortby, int _from, int _to)
    {
        sortby=_sortby;
        from=_from;
        to=_to;
        name_title=_name_title;
    }
    // sort==1 for year and ===2 for relevance
    public void doWork()
    {
        for(int i=0;i<database.allData.size();i++)
        {
            if(database.allData.get(i).getAuthor().equals(name_title)&& database.allData.get(i).getYear()>=from && database.allData.get(i).getYear()<=to)
            {
                list.add(database.allData.get(i));
            }
        }
        sort();
        //print();
        showResult();
    }

    public void sort()
    {
        Collections.sort(list);
    }




    public void add(publishables x)
    {
        list.add(x);
    }


    void print()
    {
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }

    }



    void showResult()
    {
        if(list.size()==0)
        {
            try {
                throw new myOwnExeption("No result Found");
            } catch (myOwnExeption myOwnExeption) {
                return;
            }
        }
        Object[][] temp= new Object[list.size()][8];
        for(int i=0;i<list.size();i++)
        {
            temp[i][0]=i+1;
            temp[i][1]=list.get(i).getTitle();
            temp[i][2]=list.get(i).getAuthor();
            temp[i][3]=list.get(i).getYear();
            temp[i][4]=list.get(i).getVolume();
            temp[i][5]=list.get(i).getPages();
            temp[i][6]=list.get(i).getJournal_booktitle();
            temp[i][7]=list.get(i).getUrl();
        }
        String columnNames[] = {"S.NO.", "title","author" ,"year", "volume","pages","journal/booktitle","url" };
        resultPanel.updateData(temp,columnNames);
        resultPanel.updateTable();
    }




































    /*private boolean authorbool = false,ignorebool=false,overall=false,articlebool, titlebool = false, yearbool = false, urlbool = false,volumebool=false,pagebool=false,journalbool=false;
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

    public query1Handler(int _sortby,String _name_title,int _from,int _to)
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
            if(overall)
            {
                d.add(pub);
                overall=false;
            }
            articlebool=false;
            ++c;
            if(c%100000==0)
            {
                System.out.println((c/15233.84)+" %");
            }
        }if (qName.equalsIgnoreCase("dblp")) {
            d.sort();
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
                pub.addAuthor(new String(ch, start, length));
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
    }*/
}