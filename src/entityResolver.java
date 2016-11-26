/**
 * Created by skwow on 11/10/2016.
 */
public class entityResolver
{


    //will return 1 if both are equal
    public int entity_resolution_checker(String one,String two) {
        String first_string[] = one.split(" ");
        String second_string[] = two.split(" ");
        int len1 = first_string.length;
        int len2 = second_string.length;
        char first_char_first_string = ' ';
        char second_char_first_string = ' ';
        char first_char__second_string = ' ';
        char second_char__second_string = ' ';
        char first_char_first_sting_last_name = ' ';
        char first_char_second_sting_last_name = ' ';
        char second_char_first_sting_last_name = ' ';
        char second_char_second_sting_last_name = ' ';
        char first_char_first_string_middle_name = ' ';
        char first_char_second_string_middle_name = ' ';
        char second_char_first_string_middle_name = ' ';
        char second_char_second_string_middle_name = ' ';
        try {
            first_char_first_string = first_string[0].charAt(0);
            second_char_first_string = first_string[0].charAt(1);
            first_char__second_string = second_string[0].charAt(0);
            second_char__second_string = second_string[0].charAt(1);


        } catch (NullPointerException e) {

        }
        // checking if equal
        if (one.equals(two)) {
            return 1;
        }
        else{
            int second,third,fourth,fifth;
            second=second_condition(first_string,second_string,len1, len2, first_char_first_string,second_char_first_string,first_char__second_string,
                    second_char__second_string,first_char_first_sting_last_name,first_char_second_sting_last_name,second_char_first_sting_last_name,
                    second_char_second_sting_last_name,first_char_first_string_middle_name,first_char_second_string_middle_name, second_char_first_string_middle_name,second_char_second_string_middle_name);

            third=third_condition(first_string,second_string ,len1, len2, first_char_first_string,second_char_first_string,first_char__second_string,
                    second_char__second_string,first_char_first_sting_last_name,first_char_second_sting_last_name,second_char_first_sting_last_name,
                    second_char_second_sting_last_name,first_char_first_string_middle_name,first_char_second_string_middle_name, second_char_first_string_middle_name,second_char_second_string_middle_name);

            fourth=fourth_condition(first_string,second_string ,len1, len2, first_char_first_string,second_char_first_string,first_char__second_string,
                    second_char__second_string,first_char_first_sting_last_name,first_char_second_sting_last_name,second_char_first_sting_last_name,
                    second_char_second_sting_last_name,first_char_first_string_middle_name,first_char_second_string_middle_name, second_char_first_string_middle_name,second_char_second_string_middle_name);

            fifth=fifth_condition(first_string,second_string,len1, len2, first_char_first_string,second_char_first_string,first_char__second_string,
                    second_char__second_string,first_char_first_sting_last_name,first_char_second_sting_last_name,second_char_first_sting_last_name,
                    second_char_second_sting_last_name,first_char_first_string_middle_name,first_char_second_string_middle_name, second_char_first_string_middle_name,second_char_second_string_middle_name);

            if (second==1 | third==1 |fourth==1 |fifth==1){
                return 1;
            }
        }
        return 0;
    }


    //checking if the initials are equal and the last name is same
    public int second_condition(String[] first_string,String second_string[] ,int len1, int len2, char first_char_first_string, char second_char_first_string, char first_char__second_string,
                                char second_char__second_string, char first_char_first_sting_last_name, char first_char_second_sting_last_name, char second_char_first_sting_last_name,
                                char second_char_second_sting_last_name, char first_char_first_string_middle_name, char first_char_second_string_middle_name,
                                char second_char_first_string_middle_name, char second_char_second_string_middle_name) {

        if ((first_char_first_string == first_char__second_string) && (second_char_first_string == '.' | second_char__second_string == '.')) {
            //checking if the initials are equal and the last name initial are equal and dont have any middle name
            if (len1 == 2 && len2 == 2) {
                first_char_first_sting_last_name = first_string[1].charAt(0);
                first_char_second_sting_last_name = second_string[1].charAt(0);
                second_char_first_sting_last_name = first_string[1].charAt(1);
                second_char_second_sting_last_name = second_string[1].charAt(1);
                if (first_string[1].equals(second_string[1])) {
                    return 1;
                } else if ((first_char_first_sting_last_name == first_char_second_sting_last_name) && (second_char_first_sting_last_name == '.' | second_char_second_sting_last_name == '.')) {
                    return 1;
                }
            }
            if (len1 == 3 && len2 == 3) {
                first_char_first_sting_last_name = first_string[2].charAt(0);
                first_char_second_sting_last_name = second_string[2].charAt(0);
                second_char_first_sting_last_name = first_string[2].charAt(1);
                second_char_second_sting_last_name = second_string[2].charAt(1);
                first_char_first_string_middle_name = first_string[1].charAt(0);
                first_char_second_string_middle_name = second_string[1].charAt(0);
                second_char_first_string_middle_name = first_string[1].charAt(1);
                second_char_second_string_middle_name = second_string[1].charAt(1);
                if (second_string[2].equals(first_string[2])) {
                    if ((first_char_first_string_middle_name == first_char_second_string_middle_name) && (second_char_first_string_middle_name == '.' | second_char_second_string_middle_name == '.')) {
                        return 1;
                    }
                } else if ((first_char_first_sting_last_name == first_char_second_sting_last_name) && (second_char_first_sting_last_name == '.' | second_char_second_sting_last_name == '.')) {
                    if ((first_char_first_string_middle_name == first_char_second_string_middle_name) && (second_char_first_string_middle_name == '.' | second_char_second_string_middle_name == '.')) {
                        return 1;
                    } else if (first_string[1].equals(second_string[1])) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }



    public int third_condition(String[] first_string,String second_string[] ,int len1, int len2, char first_char_first_string, char second_char_first_string, char first_char__second_string,
                               char second_char__second_string, char first_char_first_sting_last_name, char first_char_second_sting_last_name, char second_char_first_sting_last_name,
                               char second_char_second_sting_last_name, char first_char_first_string_middle_name, char first_char_second_string_middle_name,
                               char second_char_first_string_middle_name, char second_char_second_string_middle_name) {
        //missing middle name
        if (len1 > 2 | len2 > 2) {
            if (len1 > len2) {
                first_char_first_sting_last_name = first_string[2].charAt(0);
                first_char_second_sting_last_name = second_string[1].charAt(0);
                second_char_first_sting_last_name = first_string[2].charAt(1);
                second_char_second_sting_last_name = second_string[1].charAt(1);

            } else {
                first_char_first_sting_last_name = first_string[1].charAt(0);
                first_char_second_sting_last_name = second_string[2].charAt(0);
                second_char_first_sting_last_name = first_string[1].charAt(1);
                second_char_second_sting_last_name = second_string[2].charAt(1);
            }
            if (first_string[len1 - 1].equals(second_string[len2 - 1])) {
                return 1;
            } else if ((first_char_first_sting_last_name == first_char_second_sting_last_name) && (second_char_first_sting_last_name == '.' | second_char_second_sting_last_name == '.')) {
                return 1;
            }
        }

        //checking if the middle name is missing
        else if (len1 > 2 | len2 > 2) {
            if (first_string[0].equals(second_string[0])) {
                return 1;
            } else if (first_string[len1 - 1].equals(second_string[len2 - 1])) {
                return 1;
            }

        }
        return 0;
    }



    public int fourth_condition(String[] first_string,String second_string[] ,int len1, int len2, char first_char_first_string, char second_char_first_string, char first_char__second_string,
                                char second_char__second_string, char first_char_first_sting_last_name, char first_char_second_sting_last_name, char second_char_first_sting_last_name,
                                char second_char_second_sting_last_name, char first_char_first_string_middle_name, char first_char_second_string_middle_name,
                                char second_char_first_string_middle_name, char second_char_second_string_middle_name) {
        if (first_string[0].equals(second_string[0])) {
            if (len1 == 3 && len2 == 3) {
                first_char_first_sting_last_name = first_string[2].charAt(0);
                first_char_second_sting_last_name = second_string[2].charAt(0);
                second_char_first_sting_last_name = first_string[2].charAt(1);
                second_char_second_sting_last_name = second_string[2].charAt(1);
                first_char_first_string_middle_name = first_string[1].charAt(0);
                first_char_second_string_middle_name = second_string[1].charAt(0);
                second_char_first_string_middle_name = first_string[1].charAt(1);
                second_char_second_string_middle_name = second_string[1].charAt(1);
                if (second_string[2].equals(first_string[2])) {
                    if ((first_char_first_string_middle_name == first_char_second_string_middle_name) && (second_char_first_string_middle_name == '.' | second_char_second_string_middle_name == '.')) {
                        return 1;
                    }
                } else if ((first_char_first_sting_last_name == first_char_second_sting_last_name) && (second_char_first_sting_last_name == '.' | second_char_second_sting_last_name == '.')) {
                    if ((first_char_first_string_middle_name == first_char_second_string_middle_name) && (second_char_first_string_middle_name == '.' | second_char_second_string_middle_name == '.')) {
                        return 1;
                    } else if (first_string[2].equals(second_string[2])) {
                        return 1;
                    }
                }
            } else if (len1 > 2 | len2 > 2) {
                if (len1 > len2) {
                    first_char_first_sting_last_name = first_string[2].charAt(0);
                    first_char_second_sting_last_name = second_string[1].charAt(0);
                    second_char_first_sting_last_name = first_string[2].charAt(1);
                    second_char_second_sting_last_name = second_string[1].charAt(1);

                } else {
                    first_char_first_sting_last_name = first_string[1].charAt(0);
                    first_char_second_sting_last_name = second_string[2].charAt(0);
                    second_char_first_sting_last_name = first_string[1].charAt(1);
                    second_char_second_sting_last_name = second_string[2].charAt(1);
                }
                if (first_string[len1 - 1].equals(second_string[len2 - 1])) {
                    return 1;
                } else if ((first_char_first_sting_last_name == first_char_second_sting_last_name) && (second_char_first_sting_last_name == '.' | second_char_second_sting_last_name == '.')) {
                    return 1;
                }
            } else if (len1 == 2 && len2 == 2) {
                first_char_first_sting_last_name = first_string[1].charAt(0);
                first_char_second_sting_last_name = second_string[1].charAt(0);
                second_char_first_sting_last_name = first_string[1].charAt(1);
                second_char_second_sting_last_name = second_string[1].charAt(1);
                if ((first_char_first_sting_last_name == first_char_second_sting_last_name) && (second_char_first_sting_last_name == '.' | second_char_second_sting_last_name == '.')) {
                    return 1;
                }
            }
        }
        return 0;
    }


    public int fifth_condition(String[] first_string,String second_string[] ,int len1, int len2, char first_char_first_string, char second_char_first_string, char first_char__second_string,
                               char second_char__second_string, char first_char_first_sting_last_name, char first_char_second_sting_last_name, char second_char_first_sting_last_name,
                               char second_char_second_sting_last_name, char first_char_first_string_middle_name, char first_char_second_string_middle_name,
                               char second_char_first_string_middle_name, char second_char_second_string_middle_name){
        // if anyone of then has only first name
        if (len1==1 | len2==1){
            if (first_string[0].equals(second_string[0])){
                return 1;
            }
            else if((first_char_first_string==first_char__second_string)&&(second_char_first_string=='.'|second_char__second_string=='.')){
                return 1;
            }
        }
        return 0;
    }
}
