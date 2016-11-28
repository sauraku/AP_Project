package query_handlers;

import Data.data;
import Data.publishables;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by skwow on 10/27/2016.
 */
public class query3Handler
{
    private String[] authors_name;
    private int[] year;
    private ArrayList<ArrayList<publishables>> list= new ArrayList<>();
    private ArrayList<ArrayList<Integer>> values=new ArrayList<>();
    private ArrayList<Integer> predicted_values=new ArrayList<>();

    public query3Handler(String[] authors , int[] years){
        year=years;
        authors_name=authors;
    }

    public int checking_order_increasing(ArrayList<Integer> arr) {

        //checking increasing order
        int c = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) {
                c++;
            }
        }
        return c;
    }

    public int checking_order_decreasing(ArrayList<Integer> arr){

        //checking decreasing order
        int c2=0;
        for (int i=1;i<arr.size();i++){
            if (arr.get(i)>arr.get(i-1)){
                c2++;
            }
        }
        return c2;
    }

    public void extracting(String name_title,int to,int k){
        for(int i = 0; i< data.getAllData().size(); i++)
        {
            if(data.getAllData().get(i).getAuthor().equals(name_title)&& data.getAllData().get(i).getYear()<=to)
            {
                list.get(k).add(data.getAllData().get(i));
                if (values.get(k).size()>(to- data.getAllData().get(i).getYear())){
                    values.get(k).set(to- data.getAllData().get(i).getYear(),values.get(k).get(values.get(k).get(to- data.getAllData().get(i).getYear())+1));
                }
                else {
                    for (int j = 0; j<to- data.getAllData().get(i).getYear()-values.get(k).size()+1; j++){
                        values.get(k).add(0);
                    }
                    values.get(k).set(to- data.getAllData().get(i).getYear(),1);
                }
            }

        }
    }

    public int min(ArrayList<Integer> arr){
        int min=100000000;
        try{
            min=arr.get(0);
        }
        catch (IndexOutOfBoundsException e){
        }
        for (Integer v:arr){
            if (v<min){
                min=v;
            }
        }
        return min;
    }

    public int max(ArrayList<Integer> arr){
        int max=0;
        try{
            max=arr.get(0);
        }
        catch (IndexOutOfBoundsException e){
        }
        for (Integer v:arr){
            if (v>max){
                max=v;
            }
        }
        return max;
    }

    public void combiner(){
        for (int i=0;i<5;i++){
            extracting(authors_name[i],year[i],i);
            predicted_values.add(predictor(i));
        }

    }

    public int predictor(int k){
        int increasing=checking_order_increasing(values.get(k));
        int decreasing=checking_order_decreasing(values.get(k));
        int min=min(values.get(k));
        int max=max(values.get(k));

        if (increasing==values.get(k).size()) {
            int d=values.get(k).get(values.get(k).size()-1)-values.get(k).get(values.get(k).size()-2);
            return max+d;
        }

        else if (decreasing==values.get(k).size()) {
            int d = values.get(k).get(values.get(k).size() - 2) - values.get(k).get(values.get(k).size() - 1);
            if (min - d < 0) {
                return 0;
            }
            else {
                return min-d;
            }

        }

        else {
            double pred=min*(decreasing/(increasing+decreasing))+max*(increasing/(increasing+decreasing));
            int predict;
            if (decreasing>increasing){
                predict=(int) Math.floor(pred);
                if (predict-1<=0){
                    return predict;
                }
                else{
                    return predict-1;
                }
            }
            else{
                predict=(int) Math.ceil(pred);
                return predict+1;
            }
        }
    }
}
