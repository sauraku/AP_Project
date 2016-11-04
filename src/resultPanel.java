import javax.swing.*;

/**
 * Created by skwow on 10/27/2016.
 */
public class resultPanel
{
    private JScrollPane pane;
    private JTable table;
    private static Object[][] rowData={
            {"a","b","c","c","c","c","c"}
    };

    public resultPanel()
    {
        buildGui();
    }

    public JScrollPane getPane()
    {
        return pane;
    }

    public static void updateData(int index,Object[] _data)
    {
        rowData[index]=_data;
    }

    private void buildGui()
    {
        String columnNames[] = { "title","author" ,"year", "volume","pages","journal/booktitle","url" };
        table=new JTable(rowData,columnNames);
        pane=new JScrollPane(table);
    }


}
