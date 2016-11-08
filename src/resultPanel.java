import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 * Created by skwow on 10/27/2016.
 */
public class resultPanel
{
    private JScrollPane pane;
    private static JTable table;


    public static Object[][] rowData={
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

    public static void updateData(Object[][] _data)
    {
        rowData=_data;
    }

    public static void updateTable()
    {
        String columnNames[] = { "title","author" ,"year", "volume","pages","journal/booktitle","url" };
        DefaultTableModel tm = new DefaultTableModel(rowData, columnNames);
        table.setModel(tm);
    }

    private void buildGui()
    {
        String columnNames[] = { "title","author" ,"year", "volume","pages","journal/booktitle","url" };
        table=new JTable(rowData,columnNames);
        pane=new JScrollPane(table);
    }


}
