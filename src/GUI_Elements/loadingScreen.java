package GUI_Elements;

import javax.swing.*;

/**
 * Created by skwow on 11/28/2016.
 */
public class loadingScreen
{
    private JProgressBar bar;
    private JFrame loading;


    public loadingScreen(int p)
    {
        loading= new JFrame();
        loading.setSize(600,40);
        bar = new JProgressBar(0, p);
        bar.setValue(0);
        bar.setStringPainted(true);
        loading.add(bar);
        loading.setResizable(false);
        loading.setUndecorated(true);
        loading.setLocationRelativeTo(null);
        loading.setVisible(true);
    }

    public JProgressBar getBar()
    {
        return bar;
    }

    public JFrame getLoading()
    {
        return loading;
    }
}
