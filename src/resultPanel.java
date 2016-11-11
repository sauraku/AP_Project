import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by skwow on 10/27/2016.
 */
public class resultPanel
{
    private JScrollPane pane;
    private static JTable table;


    private static Object[][] rowData={
            {" "," "," "," "," "," "," "}
    };

    private static String columnNames[] = { "title","author" ,"year", "volume","pages","journal/booktitle","url" };

    public resultPanel()
    {
        buildGui();
    }

    public JScrollPane getPane()
    {
        return pane;
    }

    public static void updateData(Object[][] _data,String[] colData)
    {
        columnNames=colData;
        rowData=_data;
    }

    public static void updateTable()
    {

        DefaultTableModel tm = new DefaultTableModel(rowData, columnNames);
        table.setModel(tm);
    }

    private void buildGui()
    {
        String columnNames[] = { "title","author" ,"year", "volume","pages","journal/booktitle","url" };
        table=new JTable(rowData,columnNames);
        table.setFont(new Font("Serif", Font.BOLD, 20));
        table.setRowHeight(30);
        pane=new JScrollPane(table);
    }



}
