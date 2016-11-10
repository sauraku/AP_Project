import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

/**
 * Created by skwow on 10/27/2016.
 */
public class query2Handler
{
    private int limit;
    private HashMap<String,Integer> map = new HashMap<>();
    private int c=0;

    public query2Handler(int _k)
    {
        limit=_k;
        doWork();
    }

    public void doWork()
    {
        for(int i=0;i<database.allData.size();i++)
        {
            for(String a : database.allData.get(i).getRawAuthor())
            {
                map.put(a,0);
            }
        }
        System.out.println(map.size());
        for(int i=0;i<database.allData.size();i++)
        {
            for(String a : database.allData.get(i).getRawAuthor())
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
        showResult();
    }

    void showResult()
    {
        Object[][] temp= new Object[c][2];
        int i=0;
        for(String s: map.keySet())
        {
            if(map.get(s)>limit)
            {
                temp[i][0]=s;
                temp[i++][1]=map.get(s);
            }
        }
        String columnNames[] = { "Author","No. of publishes" };
        resultPanel.updateData(temp,columnNames);
        resultPanel.updateTable();
    }

}
