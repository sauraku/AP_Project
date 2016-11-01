import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
                System.out.println(searchBy+" "+name_title+" "+yearSelect);

            }
        });
    }

    public JPanel getPanel()
    {
        return panel;
    }
}





