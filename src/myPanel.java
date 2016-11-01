import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

/**
 * Created by skwow on 10/21/2016.
 */
public class myPanel
{
    private JPanel panel=new JPanel(new GridBagLayout()),panel2;
    private  myQuery1Panel q1p;
    private GridBagConstraints gbc= new GridBagConstraints();


    public myPanel()
    {
        panel.setOpaque(false);
        gbc.insets= new Insets(20,20,20,20);
        q1p=new myQuery1Panel();
        panel2= q1p.panel2;
        final DefaultComboBoxModel typeOfQuery = new DefaultComboBoxModel();
        typeOfQuery.addElement("Query");
        typeOfQuery.addElement("Query1");
        typeOfQuery.addElement("Query2");
        final JComboBox queryCombo = new JComboBox(typeOfQuery);
        queryCombo.setFont(new Font("Serif", Font.BOLD, 30));
        queryCombo.setSelectedIndex(0);
        queryCombo.setPreferredSize(new Dimension(200,50));
        queryCombo.setBackground(Color.cyan);
        gbc.gridx=0;
        gbc.gridy=0;
        //gbc.fill= GridBagConstraints.HORIZONTAL;
        panel.add(queryCombo,gbc);

        queryCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object temp = queryCombo.getSelectedIndex();
                if(temp.equals(1))
                {
                    panel2.setVisible(true);
                }
                else
                {
                    panel2.setVisible(false);
                }
            }
        });
        workingOfButtons();

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.weighty=4;
        panel.add(panel2,gbc);
        panel2.setVisible(false);
    }

    public void workingOfButtons()
    {
        q1p.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchBy = String.valueOf(q1p.searchByCombo.getSelectedItem());
                String name_title=q1p.nameTitleTextField.getText();
                String yearSelect = String.valueOf(q1p.yearCombo.getSelectedItem());
                //System.out.println(searchBy+" "+name_title+" "+yearSelect);
                int from,to;
                if(yearSelect.charAt(0)=='S')
                {
                    from= Integer.parseInt(q1p.sinceYearTeaxtField.getText());
                    to=9999;  }  else  {
                    from= Integer.parseInt(q1p.fromTextField.getText());
                    to=Integer.parseInt(q1p.toTextField.getText());
                }
                if(searchBy.charAt(0)=='N')
                {
                    try {
                        File inputFile = new File("dblps.xml");
                        SAXParserFactory factory = SAXParserFactory.newInstance();
                        SAXParser saxParser = factory.newSAXParser();
                        query1aHandler userhandler=null;
                        if(q1p.sort.getSelectedCheckbox().toString().charAt(26)=='0')
                            userhandler = new query1aHandler(1,name_title,from,to);
                        saxParser.parse(inputFile, userhandler);
                    } catch (Exception f) {
                        f.printStackTrace();
                    }
                }

            }
        });
    }

    public JPanel getPanel()
    {
        return panel;
    }
}





