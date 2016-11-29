//templete pattern

package query_handlers;

/**
 * Created by skwow on 11/29/2016.
 */
public abstract class queryHandlers
{
    abstract void doWork();
    abstract void showResult();
    //abstract void print();

    public final void perform()
    {
        doWork();
        showResult();
        //print();
    }
}
