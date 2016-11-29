package query_handlers;

import Data.data;
import GUI_Elements.resultPanel;
import utilities.myOwnExeption;

import java.util.HashMap;

/**
 * Created by skwow on 10/27/2016.
 */
public class query2Handler extends queryHandlers
{
    private int limit;
    private HashMap<String,Integer> map = new HashMap<>();
    private int c=0;

    ///constructor
    public query2Handler(int _k)
    {
        limit=_k;
    }

    public void doWork()
    {
        for(int i = 0; i< data.getAllData().size(); i++)
        {
            for(String a : data.getAllData().get(i).getRawAuthor())
            {
                map.put(a,0);
            }
        }
        //System.out.println(map.size());
        for(int i = 0; i< data.getAllData().size(); i++)
        {
            for(String a : data.getAllData().get(i).getRawAuthor())
            {
                map.put(a, map.get(a) + 1);
            }
        }
        for(String s: map.keySet())
        {
            if(map.get(s)>limit)
            {
                c++;
            }
        }
        //showResult();
    }

    ///sends result as 2d array to resultPanel
    void showResult()
    {
        if(c==0)
        {
            try {
                throw new myOwnExeption("No result Found");
            } catch (myOwnExeption myOwnExeption) {
                return;
            }
        }
        Object[][] temp= new Object[c][3];
        int i=0;
        for(String s: map.keySet())
        {
            if(map.get(s)>limit)
            {
                temp[i][0]=i+1;
                temp[i][1]=s;
                temp[i++][2]=map.get(s);
            }
        }
        String columnNames[] = { "S.NO.","Author","No. of publishes" };
        resultPanel.updateData(temp,columnNames);
        resultPanel.updateTable();
    }

}
