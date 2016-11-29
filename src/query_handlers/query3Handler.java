package query_handlers;

import Data.data;
import Data.publishables;
import GUI_Elements.resultPanel;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import utilities.entityResolver;
import utilities.myOwnExeption;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by skwow on 10/27/2016.
 */
public class query3Handler extends queryHandlers
{
    private String[] authors;
    private int[] years;
    private int[] actual= new int[5];
    private int[] pridicted= new int[5];
    private ArrayList<publishables> list= new ArrayList<>();
    private entityResolver er= new entityResolver();

    ///constructor
    public query3Handler (String[] _authors,int[] _years)
    {
        authors=_authors;
        years=_years;
    }

    ///use last 10% of data to guess the number of publishables
    public void doWork() {

        for(int i=0;i<5;i++)
        {
            int c=0;
            for (publishables p: data.getAllData()) {
                if (er.entity_resolution_checker(p.getAuthor().toLowerCase(), authors[i].toLowerCase()) == 1 )
                {
                    c++;
                    if( p.getYear()<=years[i]) {
                        list.add(p);
                    }
                }
            }
            sort();
            int ten=(int)(0.1*list.size())+1;
            float av= ten/(list.get(0).getYear()-list.get(ten).getYear()+1) +1;
            float f= list.size()+ av*(2016-list.get(0).getYear());
            System.out.println(c+" "+f);
            actual[i]=c;
            pridicted[i]= (int) f;
            list.clear();
        }

    }




    // sort==1 for year and ===2 for relevance


    public void sort()
    {
        Collections.sort(list);
    }




    public void add(publishables x)
    {
        list.add(x);
    }


    public void print()
    {
        System.out.println(list.size());
       /* for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }*/

    }


    ///sends result as 2d array to resultPanel
    public void showResult()
    {
        Object[][] temp= new Object[5][4];
        for(int i=0;i<5;i++)
        {
            temp[i][0]=i+1;
            temp[i][1]=authors[i];
            temp[i][2]=actual[i];
            temp[i][3]=pridicted[i];
        }
        String columnNames[] = {"S.NO.", "Author","Actual" ,"Predicted" };
        resultPanel.updateData(temp,columnNames);
        resultPanel.updateTable();
    }
}
