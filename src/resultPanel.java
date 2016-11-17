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
    private GridBagConstraints gbcrp= new GridBagConstraints();
    private JButton next,back;
    private JPanel panel= new JPanel(new GridBagLayout());

    private static Object[][] rowData={
            {" "," "," "," "," "," "," "}
    };

    private static String columnNames[] = { "title","author" ,"year", "volume","pages","journal/booktitle","url" };

    public resultPanel()
    {
        gbcrp.insets=new Insets(10,10,10,10);
        prepareButtons();
        buildGui();
    }

    public JPanel getPane()
    {
        return panel;
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
        pane.setPreferredSize(new Dimension(800,600));
        panel.setOpaque(false);
        gbcrp.gridx=0;
        gbcrp.gridy=0;
        gbcrp.gridwidth=4;
        //gbcrp.fill= GridBagConstraints.BOTH;
        panel.add(pane,gbcrp);
    }

    public void prepareButtons()
    {
        back=new JButton("Back");
        back.setBackground(Color.cyan);
        back.setFont(new Font("Serif", Font.BOLD, 30));
        back.setPreferredSize(new Dimension(200,50));
        next=new JButton("Next");
        next.setBackground(Color.cyan);
        next.setFont(new Font("Serif", Font.BOLD, 30));
        next.setPreferredSize(new Dimension(200,50));
        gbcrp.gridwidth=1;
        gbcrp.gridx=0;
        gbcrp.gridy=1;
        panel.add(back,gbcrp);
        gbcrp.gridx=3;
        gbcrp.gridy=1;
        panel.add(next,gbcrp);
    }



}
