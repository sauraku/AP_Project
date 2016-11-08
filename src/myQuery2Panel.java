import javax.swing.*;
import java.awt.*;

/**
 * Created by skwow on 10/27/2016.
 */
public class myQuery2Panel
{
    private JButton resetButton,searchButton;
    private JPanel panel3=new JPanel(new GridBagLayout());
    private GridBagConstraints panel3gbc= new GridBagConstraints();
    private JTextField field= new JTextField();
    private JLabel text= new JLabel("Threshold");

    public myQuery2Panel()
    {
        panel3gbc.insets= new Insets(10,10,10,10);
        prepareGui();
        colorize();
    }

    private void colorize()
    {
        text.setForeground(Color.cyan);
        text.setBackground(Color.gray);
        resetButton.setBackground(Color.cyan);
        searchButton.setBackground(Color.cyan);
        panel3.setBackground(Color.gray);
    }


    public void prepareGui()
    {
        field.setPreferredSize(new Dimension(200,50));
        text.setPreferredSize(new Dimension(200,50));
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
        resetButton=new JButton("Reset");
        resetButton.setBackground(Color.gray);
        resetButton.setFont(new Font("Serif", Font.BOLD, 30));
        resetButton.setPreferredSize(new Dimension(200,50));
        searchButton=new JButton("Search");
        searchButton.setBackground(Color.gray);
        searchButton.setFont(new Font("Serif", Font.BOLD, 30));
        searchButton.setPreferredSize(new Dimension(200,50));
        panel3gbc.gridx=0;
        panel3gbc.gridy=4;
        panel3.add(searchButton,panel3gbc);
        panel3gbc.gridx=1;
        panel3gbc.gridy=4;
        panel3.add(resetButton,panel3gbc);
    }

    public JPanel getPanel()
    {
        return panel3;
    }
}
