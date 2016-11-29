package utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by skwow on 11/21/2016.
 */

///this is meant for exception handling by creating dialog box.
public class myOwnExeption extends Exception
{
    private String error;
    private JButton ok = new JButton("OK");
    private JFrame frame = new JFrame("ERROR");

    ///constructors takes a string
    public myOwnExeption(String s)
    {
        error=s;
        buildErrorScreen();
        workingOfOK();
    }

    ///this builds error message by displaying that string
    private void buildErrorScreen()
    {

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets= new Insets(10,10,10,10);
        panel.setOpaque(false);
        frame.setSize(new Dimension(500,300));
        JLabel lebel= new JLabel(error);
        lebel.setFont(new Font("Serif", Font.BOLD, 30));
        gbc.gridx=0;
        gbc.gridy=0;
        panel.add(lebel,gbc);
        gbc.gridy=1;
        ok.setPreferredSize(new Dimension(200,50));
        ok.setBackground(Color.cyan);
        ok.setFont(new Font("Serif", Font.BOLD, 30));
        panel.add(ok,gbc);
        frame.add(panel);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void workingOfOK()
    {
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
