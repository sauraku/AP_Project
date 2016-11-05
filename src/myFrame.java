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
    private static JProgressBar bar;


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
        frame.add(heading,framegbc);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        framegbc.gridwidth=1;
        framegbc.gridx=0;
        framegbc.gridy=1;
        frame.add(panel.getPanel(),framegbc);

        JScrollPane pane= new resultPanel().getPane();
        pane.setPreferredSize(new Dimension(800,800));
        framegbc.gridwidth=4;
        framegbc.gridheight=6;
        framegbc.gridx=1;
        framegbc.gridy=1;
        frame.add(pane,framegbc);

       /* bar = new JProgressBar(0, 1523000);
        bar.setValue(0);
        bar.setStringPainted(true);
        framegbc.gridwidth=5;
        framegbc.gridheight=1;
        framegbc.gridx=0;
        framegbc.gridy=2;
        frame.add(bar,framegbc);*/


        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(1800,1500);
        frame.setVisible(true);
    }

    public static JProgressBar getBar()
    {
        return bar;
    }


}
