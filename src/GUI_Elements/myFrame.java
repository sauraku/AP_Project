package GUI_Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

/**
 * Created by skwow on 10/23/2016.
 */

///main GUI frame
public class myFrame extends JFrame
{
    private Point point=null;
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel heading;



    public myFrame(myPanel panel)
    {
        mainPanel=panel.getPanel();
        prepareFrame();
        addDraggable();
    }


    private void prepareFrame()
    {
        heading=new JLabel("DBLP Query Engine", SwingConstants.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        //heading.setBackground(Color.black);
        heading.setForeground(Color.cyan);
        frame=new JFrame("DBLP Query Engine");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints framegbc=new GridBagConstraints();
        framegbc.insets=new Insets(20,20,20,20);
        framegbc.fill= GridBagConstraints.HORIZONTAL;
        framegbc.gridwidth=5;
        framegbc.gridheight=1;
        framegbc.gridx=0;
        framegbc.gridy=0;
        frame.add(heading,framegbc);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        framegbc.gridwidth=1;
        framegbc.gridheight=6;//framegbc.gridx=0;
        framegbc.gridy=1;
        framegbc.anchor= GridBagConstraints.WEST;
        frame.add(mainPanel,framegbc);
        JPanel pane= new resultPanel().getPane();
        pane.setPreferredSize(new Dimension(800,800));
        framegbc.gridwidth=1;
        framegbc.gridheight=6;
        framegbc.gridx=1;//framegbc.gridy=1;
        framegbc.weightx=1.0;
        framegbc.weighty=1.0;
        framegbc.anchor= GridBagConstraints.EAST;
        frame.add(pane,framegbc);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(1800,1500);
        frame.setMinimumSize(new Dimension(1600,1000));
        frame.setVisible(true);
    }

    ///one can drag it by clicking anywhere on the frame
    public void addDraggable()
    {
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) { point=e.getPoint();}
            @Override
            public void mouseReleased(MouseEvent e) {point=null; }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getLocationOnScreen().x - point.x, e.getLocationOnScreen().y - point.y);
            }
            @Override
            public void mouseMoved(MouseEvent e) { }
        });
    }



}
