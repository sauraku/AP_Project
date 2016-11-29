//templete pattern
package GUI_Elements;

/**
 * Created by skwow on 11/29/2016.
 */
public abstract class queryPanels
{
    abstract void colorize();
    abstract void prepareGui();
    abstract void prepareButtons();
    abstract void workingOfButtons();


    public final void prepare()
    {
        prepareGui();
        prepareButtons();
        workingOfButtons();
        colorize();
    }
}
