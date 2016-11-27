import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by skwow on 10/18/2016.
 *
 */

//sortby 0== year 1==relevence
//name=0        title=1
public class query1Handler  {

    private int sortby,nametitle,from,to;
    private String name_title;
    private ArrayList<publishables> list= new ArrayList<>();

    public query1Handler(String _name_title, int _sortby,int _nametitle, int _from, int _to)
    {
        nametitle=_nametitle;
        sortby=_sortby;
        from=_from;
        to=_to;
        name_title=_name_title;
    }
    // sort==1 for year and ===2 for relevance
    public void doWork()
    {
        //System.out.println("nametitle="+nametitle);
        if(nametitle==0) {
            for (int i = 0; i < data.getAllData().size(); i++) {
                if (data.getAllData().get(i).getAuthor().equalsIgnoreCase(name_title) && data.getAllData().get(i).getYear() >= from && data.getAllData().get(i).getYear() <= to) {
                    list.add(data.getAllData().get(i));
                }
            }
        }
        else if(nametitle==1)
        {
            for (int i = 0; i < data.getAllData().size(); i++) {
                if (data.getAllData().get(i).getTitle().equalsIgnoreCase(name_title) && data.getAllData().get(i).getYear() >= from && data.getAllData().get(i).getYear() <= to) {
                    list.add(data.getAllData().get(i));
                }
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
}