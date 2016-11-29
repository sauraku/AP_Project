package GUI_Elements;

import query_handlers.query2Handler;
import utilities.myOwnExeption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by skwow on 10/27/2016.
 */
public class myQuery2Panel extends queryPanels
{
    private JButton resetButton,searchButton;
    private JPanel panel3=new JPanel(new GridBagLayout());
    private GridBagConstraints panel3gbc= new GridBagConstraints();
    private JTextField field= new JTextField();
    private JLabel text= new JLabel("Threshold");
    ///constructor initiates the skeleton of interface
    public myQuery2Panel()
    {
        panel3gbc.weightx=1;
        panel3gbc.weighty=1;
        panel3gbc.fill = GridBagConstraints.BOTH;
        panel3gbc.insets= new Insets(10,10,10,10);
        this.prepare();
    }

    public void colorize()
    {
        text.setForeground(Color.cyan);
        text.setBackground(Color.gray);
        resetButton.setBackground(Color.cyan);
        searchButton.setBackground(Color.cyan);
        panel3.setBackground(Color.gray);
    }


    public void prepareGui()
    {
        //field.setPreferredSize(new Dimension(200,50));
        //text.setPreferredSize(new Dimension(200,50));
        text.setFont(new Font("Serif", Font.BOLD, 30));
        field.setFont(new Font("Serif", Font.BOLD, 30));
        panel3gbc.gridx=0;
        panel3gbc.gridy=0;
        panel3.add(text,panel3gbc);
        panel3gbc.gridx=0;
        panel3gbc.gridy=1;
        panel3.add(field,panel3gbc);
        JLabel l1=new JLabel("      ");
        JLabel l2=new JLabel("      ");
        panel3gbc.gridy=2;
        panel3.add(l1,panel3gbc);
        panel3gbc.gridy=3;
        panel3.add(l2,panel3gbc);

    }

    public void prepareButtons()
    {
        resetButton=new JButton("Reset");
        resetButton.setBackground(Color.gray);
        resetButton.setFont(new Font("Serif", Font.BOLD, 30));
        //resetButton.setPreferredSize(new Dimension(200,50));
        searchButton=new JButton("Search");
        searchButton.setBackground(Color.gray);
        searchButton.setFont(new Font("Serif", Font.BOLD, 30));
        //searchButton.setPreferredSize(new Dimension(200,50));
        panel3gbc.gridx=0;
        panel3gbc.gridy=4;
        panel3.add(searchButton,panel3gbc);
        panel3gbc.gridx=1;
        panel3gbc.gridy=4;
        panel3.add(resetButton,panel3gbc);
    }

    public void workingOfButtons()
    {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k= Integer.parseInt(field.getText());
                try {
                    if (k < 0) {
                        throw new myOwnExeption("threshold can't be negetive!");
                    }
                    query2Handler q2 = new query2Handler(k);
                    q2.perform();
                } catch (myOwnExeption myOwnExeption) { }
            }
        });
    }

    public JPanel getPanel()
    {
        return panel3;
    }
}
