package GUI_Elements;

import query_handlers.query3Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by skwow on 10/27/2016.
 */
public class myQuery3Panel extends queryPanels
{
    private JButton resetButton,searchButton;
    private JPanel panel4 =new JPanel(new GridBagLayout());
    private GridBagConstraints panel4gbc = new GridBagConstraints();
    private JTextField ThresholdField1 = new JTextField(),ThresholdField2 = new JTextField(),ThresholdField3 = new JTextField(),ThresholdField4 = new JTextField(),ThresholdField5 = new JTextField();
    private JLabel ThrasholdText = new JLabel("Threshold");
    private JTextField nameField1= new JTextField(),nameField2= new JTextField(),nameField3= new JTextField(),nameField4= new JTextField(),nameField5= new JTextField();
    private JLabel nameText= new JLabel("Author Name");

    public myQuery3Panel()
    {
        panel4gbc.weightx=1;
        panel4gbc.weighty=1;
        panel4gbc.fill = GridBagConstraints.BOTH;
        panel4gbc.insets= new Insets(10,10,10,10);
        this.prepare();
    }

    public void colorize()
    {
        ThrasholdText.setForeground(Color.cyan);
        ThrasholdText.setBackground(Color.gray);
        nameText.setForeground(Color.cyan);
        nameText.setBackground(Color.gray);
        resetButton.setBackground(Color.cyan);
        searchButton.setBackground(Color.cyan);
        panel4.setBackground(Color.gray);
    }

    private void setFont()
    {
        ThrasholdText.setFont(new Font("Serif", Font.BOLD, 30));
        ThresholdField1.setFont(new Font("Serif", Font.BOLD, 30));
        ThresholdField2.setFont(new Font("Serif", Font.BOLD, 30));
        ThresholdField3.setFont(new Font("Serif", Font.BOLD, 30));
        ThresholdField4.setFont(new Font("Serif", Font.BOLD, 30));
        ThresholdField5.setFont(new Font("Serif", Font.BOLD, 30));
        nameText.setFont(new Font("Serif", Font.BOLD, 30));
        nameField1.setFont(new Font("Serif", Font.BOLD, 30));
        nameField2.setFont(new Font("Serif", Font.BOLD, 30));
        nameField3.setFont(new Font("Serif", Font.BOLD, 30));
        nameField4.setFont(new Font("Serif", Font.BOLD, 30));
        nameField5.setFont(new Font("Serif", Font.BOLD, 30));
    }


    public void prepareGui()
    {
        setFont();
        panel4gbc.gridx=0;
        panel4gbc.gridy=0;
        panel4.add(ThrasholdText, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=0;
        panel4.add(nameText, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=1;
        panel4.add(ThresholdField1, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=2;
        panel4.add(ThresholdField2, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=3;
        panel4.add(ThresholdField3, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=4;
        panel4.add(ThresholdField4, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=5;
        panel4.add(ThresholdField5, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=1;
        panel4.add(nameField1, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=2;
        panel4.add(nameField2, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=3;
        panel4.add(nameField3, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=4;
        panel4.add(nameField4, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=5;
        panel4.add(nameField5, panel4gbc);

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
        panel4gbc.gridx=0;
        panel4gbc.gridy=6;
        //setButtons();
        panel4.add(searchButton, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=6;
        panel4.add(resetButton, panel4gbc);
    }

    public void workingOfButtons()
    {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThresholdField1.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] authorTemp=new String[5];
                int[] yearTemp=new int[5];
                authorTemp[0]=nameField1.getText();
                authorTemp[1]=nameField2.getText();
                authorTemp[2]=nameField3.getText();
                authorTemp[3]=nameField4.getText();
                authorTemp[4]=nameField5.getText();
                yearTemp[0]= Integer.parseInt(ThresholdField1.getText());
                yearTemp[1]= Integer.parseInt(ThresholdField2.getText());
                yearTemp[2]= Integer.parseInt(ThresholdField3.getText());
                yearTemp[3]= Integer.parseInt(ThresholdField4.getText());
                yearTemp[4]= Integer.parseInt(ThresholdField5.getText());
                query3Handler q= new query3Handler(authorTemp,yearTemp);
            }
        });
    }

    public JPanel getPanel()
    {
        return panel4;
    }
}



//Chi-Wang Shu
//Antonio Fern
//Lutz Bornmann