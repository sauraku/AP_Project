package utilities;

/**
 * Created by skwow on 11/10/2016.
 */
public class entityResolver
{
    // checkig if one of the string of the name is equal or not
    public int checking_a_string_to_be_equal(String a,String b){
        if (a.equals(b)){
            return 1;
        }
        else if (a.charAt(0)==b.charAt(0)) {
            try {
                if (a.charAt(1) == '.' | b.charAt(1) == '.')
                { return 1;}
            }catch (IndexOutOfBoundsException e){}
        }
        return 0;
    }


    // Conditions for those name whose lenght is not same
    public int variable_lenght(String[] one ,String[] two){
        int q=one.length;
        int w=two.length;
        if (checking_a_string_to_be_equal(one[0],two[0])==1 &&checking_a_string_to_be_equal(one[q-1],two[w-1])==1){
            q-=2;
            w-=2;
            int qa=1;
            int wa=1;
            while(q>0 && w>0){
                if (checking_a_string_to_be_equal(one[qa],two[wa])==1){
                    qa+=1;wa+=1;q-=1;w-=1;
                }
                else if (one.length>two.length){
                    qa+=1;q-=1;
                }
                else if(two.length>one.length){
                    wa+=1;w-=1;
                }
            }
        }
        if (one.length>two.length && w==0){
            return 1;
        }
        else if (one.length<two.length && q==0){
            return 1;
        }
        return 0;
    }


    // Combining all
    public int entity_resolution_checker(String one,String two){
        String[] one_string=one.split(" ");
        String[] two_string=two.split(" ");
        int len1=one_string.length;
        int len2=two_string.length;

        if (len1==1 | len2==1){
            if(checking_a_string_to_be_equal(one_string[0],two_string[0])==1)
            return 1;
        }

        if (len1==len2){
            int c=0;
            for (int i=0;i<len1;i++){
                c+=checking_a_string_to_be_equal(one_string[i],two_string[i]);
            }

            if (c==len1){
                return 1;
            }
        }

        else if(len1>len2 | len2>len1 ){
            if (variable_lenght(one_string,two_string)==1){
                return 1;
            }
        }
        return 0;
    }
}
