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
