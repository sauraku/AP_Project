public class mainClass {
    public static void main(String[] args){
        parser h = new parser();
        myPanel panel = new myPanel();
        myFrame frame= new myFrame(panel);
        frame.setLocationRelativeTo(null);
    }
}

//artist shows only.. gotta fix it
//also make sort by relevence robust by matching substringss
//entity resolution