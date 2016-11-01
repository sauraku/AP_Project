
/**
 * Created by skwow on 10/14/2016.
 */

public class publishables implements Comparable
{
    protected String title;
    protected int year;
    protected String volume;
    protected String pages;
    protected String journal_booktitle;
    protected String[] url;
    protected String[] authors;

    @Override
    public int compareTo(Object o) {
        int temp= ((publishables) o).year;
        return temp-this.year;
    }
}
