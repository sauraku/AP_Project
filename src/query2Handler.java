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


    public query2Handler(int _k)
    {
        limit=_k;
    }

    public void doWork()
    {
        for(int i=0;i<database.allData.size();i++)
        {

        }
    }

}
