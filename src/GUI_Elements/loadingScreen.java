//decorator pattern

package GUI_Elements;

import javax.swing.*;

/**
 * Created by skwow on 11/28/2016.
 */

///loading screen that pops up while reading xml file.
public class loadingScreen extends JFrame
{


    private JProgressBar bar;
    private JFrame loading;
    private int p;

    ///constructor makes gui by taking Jframe, dynamically
    ///Example of decorator pattern.
    public loadingScreen(JFrame frame,int _p)
    {
        loading= frame;
        p=_p;
        prepareGui();

    }

    public void prepareGui()
    {
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
