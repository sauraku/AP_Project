import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by skwow on 10/27/2016.
 */
public class database
{

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
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        showResult();
    }



    void showResult()
    {
        Object[][] temp= new Object[list.size()][7];
        for(int i=0;i<list.size();i++)
        {
            temp[i][0]=list.get(i).getTitle();
            temp[i][1]=list.get(i).getAuthor();
            temp[i][2]=list.get(i).getYear();
            temp[i][3]=list.get(i).getVolume();
            temp[i][4]=list.get(i).getPages();
            temp[i][5]=list.get(i).getJournal_booktitle();
            temp[i][6]=list.get(i).getUrl();
        }
        resultPanel.updateData(temp);

    }

}
