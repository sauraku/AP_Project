
package GUI_Elements;

/**
 * Created by skwow on 11/29/2016.
 * saurabh kumar 2015088
 * prashant 2015072
 */

///template pattern. for all the different querypanels
public abstract class queryPanels
{
    abstract void colorize();
    abstract void prepareGui();
    abstract void prepareButtons();
    abstract void workingOfButtons();

    ///skeleton
    public final void prepare()
    {
        prepareGui();
        prepareButtons();
        workingOfButtons();
        colorize();
    }
}
