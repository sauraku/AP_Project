import javax.swing.*;

/**
 * Created by skwow on 10/27/2016.
 */
public class resultPanel
{
    private JScrollPane pane;
    private JPanel panel;
    private JTable table;
    private Object[][] rowData={
            {"a","b","c","c","c","c","c"}
    };

    public resultPanel()
    {
        panel=new JPanel();
        buildGui();
    }

    public void updateData(int index,Object[] _data)
    {
        rowData[index]=_data;
    }

    private void buildGui()
    {
        Object columnNames[] = { "title","author" ,"year", "volume","pages","journal/booktitle","url" };
        table=new JTable(rowData,columnNames);
        panel.add(table);
        pane=new JScrollPane(panel);
    }


    public static void main(String[] args)
    {
        resultPanel test = new resultPanel();
        JFrame x = new JFrame();
        x.add(test.pane);
        x.setVisible(true);
        x.setSize(400,300);

    }
}
