import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by skwow on 10/27/2016.
 */
public class database
{
    //store
    //sort
    //display

    private ArrayList<publishables> list= new ArrayList<>();

    public void sort()
    {
        Collections.sort(list);
    }



    public int getArrayLength()
    {
        return list.size();
    }

    public void add(publishables x)
    {
        list.add(x);
    }

    public void clearlist()
    {
        list= new ArrayList<>();
    }

    void print()
    {
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }

}
