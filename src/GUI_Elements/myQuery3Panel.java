package GUI_Elements;

import query_handlers.query3Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by skwow on 10/27/2016.
 */
public class myQuery3Panel
{
    private JButton resetButton,searchButton;
    private JPanel panel4 =new JPanel(new GridBagLayout());
    private GridBagConstraints panel4gbc = new GridBagConstraints();
    private JTextField ThrasholdField = new JTextField();
    private JLabel ThrasholdText = new JLabel("Threshold");
    private JTextField nameField= new JTextField();
    private JLabel nameText= new JLabel("Author Name");

    public myQuery3Panel()
    {
        panel4gbc.weightx=1;
        panel4gbc.weighty=1;
        panel4gbc.fill = GridBagConstraints.BOTH;
        panel4gbc.insets= new Insets(10,10,10,10);
        prepareGui();
        colorize();
        buttonWorking();
    }

    private void colorize()
    {
        ThrasholdText.setForeground(Color.cyan);
        ThrasholdText.setBackground(Color.gray);
        nameText.setForeground(Color.cyan);
        nameText.setBackground(Color.gray);
        resetButton.setBackground(Color.cyan);
        searchButton.setBackground(Color.cyan);
        panel4.setBackground(Color.gray);
    }


    public void prepareGui()
    {
        //ThrasholdField.setPreferredSize(new Dimension(200,50));
        //ThrasholdText.setPreferredSize(new Dimension(200,50));
        ThrasholdText.setFont(new Font("Serif", Font.BOLD, 30));
        ThrasholdField.setFont(new Font("Serif", Font.BOLD, 30));
        //nameField.setPreferredSize(new Dimension(200,50));
        //nameText.setPreferredSize(new Dimension(200,50));
        nameText.setFont(new Font("Serif", Font.BOLD, 30));
        nameField.setFont(new Font("Serif", Font.BOLD, 30));
        panel4gbc.gridx=0;
        panel4gbc.gridy=0;
        panel4.add(ThrasholdText, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=1;
        panel4.add(ThrasholdField, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=2;
        panel4.add(nameText, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=3;
        panel4.add(nameField, panel4gbc);
        JLabel l1=new JLabel("      ");
        JLabel l2=new JLabel("      ");
        panel4gbc.gridy=4;
        panel4.add(l1, panel4gbc);
        panel4gbc.gridy=5;
        panel4.add(l2, panel4gbc);
        resetButton=new JButton("Reset");
        resetButton.setBackground(Color.gray);
        resetButton.setFont(new Font("Serif", Font.BOLD, 30));
        //resetButton.setPreferredSize(new Dimension(200,50));
        searchButton=new JButton("Search");
        searchButton.setBackground(Color.gray);
        searchButton.setFont(new Font("Serif", Font.BOLD, 30));
        //searchButton.setPreferredSize(new Dimension(200,50));
        panel4gbc.gridx=0;
        panel4gbc.gridy=6;
        panel4.add(searchButton, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=6;
        panel4.add(resetButton, panel4gbc);
    }

    public void buttonWorking()
    {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThrasholdField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] authorTemp=new String[1];
                int[] yearTemp=new int[1];
                authorTemp[0]=nameField.getText();
                yearTemp[0]= Integer.parseInt(ThrasholdField.getText());
                query3Handler q= new query3Handler(authorTemp,yearTemp);
            }
        });
    }

    public JPanel getPanel()
    {
        return panel4;
    }
}
