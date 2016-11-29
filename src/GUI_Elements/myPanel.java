//factory pattern
package GUI_Elements;

import query_handlers.query1Handler;
import utilities.myOwnExeption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by skwow on 10/21/2016.
 */

///main panel inside myFrame
public class myPanel
{
    private JPanel panel=new JPanel(new GridBagLayout()),panel2,panel3,panel4;
    private  myQuery1Panel q1p;
    private myQuery2Panel p3;
    private myQuery3Panel p4;
    private GridBagConstraints gbc= new GridBagConstraints();
    private JComboBox queryCombo;
    /// factory pattern for all the gui panel needed by this panel
    public void UIElementFactory()
    {
        q1p=new myQuery1Panel();
        panel2= q1p.panel2;
        p3=new myQuery2Panel();
        p4=new myQuery3Panel();
        panel3=p3.getPanel();
        panel4=p4.getPanel();
    }

    public myPanel()
    {
        UIElementFactory();
        panel.setOpaque(false);
        gbc.insets= new Insets(20,20,20,20);
        final DefaultComboBoxModel typeOfQuery = new DefaultComboBoxModel();
        typeOfQuery.addElement("Query");
        typeOfQuery.addElement("Query1");
        typeOfQuery.addElement("Query2");
        typeOfQuery.addElement("Query3");
        queryCombo = new JComboBox(typeOfQuery);
        queryCombo.setFont(new Font("Serif", Font.BOLD, 30));
        queryCombo.setSelectedIndex(0);
        queryCombo.setPreferredSize(new Dimension(200,50));
        queryCombo.setBackground(Color.cyan);
        gbc.gridx=0;
        gbc.gridy=0;//gbc.fill= GridBagConstraints.HORIZONTAL;
        panel.add(queryCombo,gbc);
        workingOfResetButton();
        workingOfSearchButton();
        workingOfQueryCombo();
        panel.setPreferredSize(new Dimension(600,800));
        //gbc.gridx=0;
        gbc.gridy=1;
        gbc.weighty=4;
        panel.add(panel2,gbc);
        panel.add(panel3,gbc);
        panel.add(panel4,gbc);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
    }

    ///switching of panel by selecting type of query
    public void workingOfQueryCombo()
    {
        queryCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object temp = queryCombo.getSelectedIndex();
                if(temp.equals(1))
                {
                    panel2.setVisible(true);
                    panel3.setVisible(false);
                    panel4.setVisible(false);
                }
                else if(temp.equals(2))
                {
                    panel2.setVisible(false);
                    panel3.setVisible(true);
                    panel4.setVisible(false);
                }
                else if(temp.equals(0))
                {
                    panel2.setVisible(false);
                    panel3.setVisible(false);
                    panel4.setVisible(false);
                }
                else
                {
                    panel2.setVisible(false);
                    panel3.setVisible(false);
                    panel4.setVisible(true);
                }
            }
        });
    }

    public void workingOfResetButton()
    {
        q1p.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q1p.toTextField.setText("");
                q1p.sinceYearTeaxtField.setText("");
                q1p.nameTitleTextField.setText("");
                q1p.fromTextField.setText("");
            }
        });
    }

    public void workingOfSearchButton()
    {
        q1p.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchBy = String.valueOf(q1p.searchByCombo.getSelectedItem());
                if(searchBy.charAt(0)=='S'){try {
                    throw new myOwnExeption("please select from searchBy dropdown");
                } catch (myOwnExeption myOwnExeption) {return;} }
                String name_title = q1p.nameTitleTextField.getText();
                if(name_title.equals("")){try {
                    throw new myOwnExeption("please fill name/title field");
                } catch (myOwnExeption myOwnExeption) {return;} }
                String yearSelect = String.valueOf(q1p.yearCombo.getSelectedItem());
                if(yearSelect.charAt(0)=='Y'){try {
                    throw new myOwnExeption("please select from yearSelect dropdown");
                } catch (myOwnExeption myOwnExeption) {return;} }
                String sortBy;
                try {
                    sortBy = q1p.sort.getSelectedCheckbox().getName();
                } catch (Exception e1){
                    try {
                        throw new myOwnExeption("please select one of the radio buttons");
                    } catch (myOwnExeption myOwnExeption) {return;}
                }//System.out.println(searchBy+" "+name_title+" "+yearSelect+" "+sortBy);
                int from, to;
                if (yearSelect.charAt(0) == 'S') {
                    from = Integer.parseInt(q1p.sinceYearTeaxtField.getText());
                    to = 2016;
                } else {
                    from = Integer.parseInt(q1p.fromTextField.getText());
                    to = Integer.parseInt(q1p.toTextField.getText());
                }
                if(from >2016 || from <0 || to >2016 || to<0) {
                    try {
                        throw new myOwnExeption("year range is 0-2016 only!");
                    } catch (myOwnExeption myOwnExeption) {return;}
                }
                if(to<from) {
                    try {
                        throw new myOwnExeption("\"To\" can't be less than \"From\"");
                    } catch (myOwnExeption myOwnExeption) {return;}
                }
                char searchType=searchBy.charAt(0);
                dowork(searchType,name_title,sortBy.charAt(8)-'0',from,to);
            }
        });
    }



    ///clicking on search button will collect relevent data from panel and send it to this function
    private void dowork(char searchType,String _nameTitle,int sortByType,int _from,int to)
    {
        if (searchType == 'N') {
                query1Handler q1 = new query1Handler(_nameTitle, sortByType,0, _from, to);
                q1.perform();
        }else if (searchType == 'T') {
                query1Handler q1 = new query1Handler(_nameTitle, sortByType,1, _from, to);
                q1.perform();
        }
    }


    public JPanel getPanel()
    {
        return panel;
    }
}





