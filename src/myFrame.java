import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

import static java.awt.SystemColor.window;

/**
 * Created by skwow on 10/23/2016.
 */
public class myFrame extends JFrame
{
    private Point point=null;
    private JFrame frame;
    private JPanel mainPanel,topPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JLabel heading;
    private JButton close=new JButton("X"),maximize=new JButton("^"),minimize=new JButton("-");


    public myFrame(myPanel panel)
    {
        mainPanel=panel.getPanel();
        prepareTopPanel();
        prepareFrame();
        addDraggable();
        makeButtonWork();
    }
    private void makeButtonWork()
    {
        close.addActionListener(e -> {
            System.exit(0);
        });
        minimize.addActionListener(e -> {
            frame.setState(JFrame.ICONIFIED);
        });
        maximize.addActionListener(e -> {
            if(getExtendedState()==NORMAL)
                setExtendedState(MAXIMIZED_BOTH);
            else
                setExtendedState(NORMAL);
        });
    }

    public void prepareTopPanel()
    {
        topPanel.setOpaque(false);
        close.setFont(new Font("Serif", Font.BOLD, 30));
        close.setBackground(Color.GRAY);
        close.setForeground(Color.cyan);
        minimize.setFont(new Font("Serif", Font.BOLD, 30));
        minimize.setBackground(Color.GRAY);
        minimize.setForeground(Color.cyan);
        maximize.setFont(new Font("Serif", Font.BOLD, 30));
        maximize.setBackground(Color.GRAY);
        maximize.setForeground(Color.cyan);
        minimize.setFocusPainted(false);
        maximize.setFocusPainted(false);
        close.setFocusPainted(false);
        topPanel.add(minimize);
        topPanel.add(maximize);
        topPanel.add(close);
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
        frame.add(topPanel,framegbc);
        framegbc.gridy=1;
        frame.add(heading,framegbc);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        framegbc.gridwidth=1;
        framegbc.gridheight=6;
        //framegbc.gridx=0;
        framegbc.gridy=2;
        framegbc.anchor= GridBagConstraints.WEST;
        frame.add(mainPanel,framegbc);

        JPanel pane= new resultPanel().getPane();
        pane.setPreferredSize(new Dimension(800,800));
        framegbc.gridwidth=1;
        framegbc.gridheight=6;
        framegbc.gridx=1;
        //framegbc.gridy=1;
        framegbc.weightx=1.0;
        framegbc.weighty=1.0;
        framegbc.anchor= GridBagConstraints.EAST;
        frame.add(pane,framegbc);

        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(1800,1080);
        frame.setUndecorated(true);
        frame.setMinimumSize(new Dimension(1600,1000));
        frame.setVisible(true);
    }


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
