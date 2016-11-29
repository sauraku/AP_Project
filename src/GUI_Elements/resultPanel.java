package GUI_Elements;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by skwow on 10/27/2016.
 * saurabh kumar 2015088
 * prashant 2015072
 */
///contains output box for result
public class resultPanel
{
    private JScrollPane pane;
    private static JTable table;
    private GridBagConstraints gbcrp= new GridBagConstraints();
    private static JButton next,back;
    private JPanel panel= new JPanel(new GridBagLayout());
    private static int track=0;

    private static Object[][] rowData={
            {" "," "," "," "," "," "," "," " }
    };

    private static String columnNames[] = { "S.NO.","title","author" ,"year", "volume","pages","journal/booktitle","url" };

    public resultPanel()
    {
        gbcrp.insets=new Insets(10,10,10,10);
        buildGui();
        prepareButtons();
        workingOfButtons();
    }

    public JPanel getPane()
    {
        return panel;
    }

    public static void updateData(Object[][] _data,String[] colData)
    {
        track=0;
        columnNames=colData;
        rowData=_data;
        if(rowData.length>20) {next.setEnabled(true);}
    }
    ///responsible for ensuring only 20 lines goes at a time
    public static void updateTable()
    {
        //System.out.println("-------"+rowData.length);
        Object[][] rowDataTemp=new Object[20][rowData[0].length];
        for(int i=track;i<rowData.length && i<track+20;i++)
        {
            for(int j=0;j<rowData[0].length;j++)
            {
                //System.out.println(i+" "+j);
                rowDataTemp[i-track][j]=rowData[i][j];
            }
        }
        DefaultTableModel tm = new DefaultTableModel(rowDataTemp, columnNames);
        table.setModel(tm);
    }

    private void buildGui()
    {
        String columnNames[] = { "S.NO.","title","author" ,"year", "volume","pages","journal/booktitle","url" };
        table=new JTable(rowData,columnNames);
        table.setFont(new Font("Serif", Font.BOLD, 20));
        table.setRowHeight(40);
        pane=new JScrollPane(table);
        //pane.setPreferredSize(new Dimension(800,600));
        panel.setOpaque(false);
        gbcrp.weightx=1.0;
        gbcrp.weighty=1.0;
        gbcrp.gridx=0;
        gbcrp.gridy=0;
        gbcrp.gridwidth=4;
        gbcrp.fill= GridBagConstraints.BOTH;
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
        back.setEnabled(false);
        next.setEnabled(false);
        gbcrp.fill= GridBagConstraints.NONE;
        gbcrp.weightx=1;
        gbcrp.weighty=0;
        gbcrp.gridwidth=1;
        gbcrp.gridx=0;
        gbcrp.gridy=1;
        panel.add(back,gbcrp);
        gbcrp.gridx=3;
        gbcrp.gridy=1;
        panel.add(next,gbcrp);
    }

    private void workingOfButtons()
    {
        next.addActionListener(e -> {
            if(track+20<rowData.length)
            {
                back.setEnabled(true);
                track=track+20;
                updateTable();
            }
            else
            {
                next.setEnabled(false);
            }
        });

        back.addActionListener(e -> {
            if(track>0)
            {
                next.setEnabled(true);
                track=track-20;
                updateTable();
            }
            else
            {
                back.setEnabled(false);
            }
        });
    }

}
