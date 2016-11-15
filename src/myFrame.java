import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by skwow on 10/23/2016.
 */
public class myFrame extends JFrame
{
    private JFrame frame;
    private JLabel heading;


    public myFrame(myPanel panel)
    {

        heading=new JLabel("DBLP Query Engine", SwingConstants.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        //heading.setBackground(Color.black);
        heading.setForeground(Color.cyan);
        frame=new JFrame();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints framegbc=new GridBagConstraints();
        framegbc.insets=new Insets(20,20,20,20);

        framegbc.fill= GridBagConstraints.HORIZONTAL;
        framegbc.gridx=0;
        framegbc.gridy=0;
        framegbc.gridwidth=5;
        framegbc.gridheight=1;
        frame.add(heading,framegbc);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        framegbc.gridwidth=1;
        framegbc.gridheight=6;
        framegbc.gridx=0;
        framegbc.gridy=1;
        framegbc.anchor= GridBagConstraints.WEST;
        frame.add(panel.getPanel(),framegbc);

        JScrollPane pane= new resultPanel().getPane();
        pane.setPreferredSize(new Dimension(600,800));
        framegbc.gridwidth=4;
        framegbc.gridheight=6;
        framegbc.gridx=1;
        framegbc.gridy=1;
        framegbc.weightx=1.0;
        framegbc.weighty=1.0;
        framegbc.anchor= GridBagConstraints.EAST;
        frame.add(pane,framegbc);


        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(1800,1500);
        frame.setVisible(true);
    }



}
