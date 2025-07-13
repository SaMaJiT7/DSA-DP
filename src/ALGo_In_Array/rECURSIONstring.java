package ALGo_In_Array;

public class rECURSIONstring {
    public static void main(String[] args) {
        String str = "kgjkiwijkigk";
        String str1 = "";
        //deletion(str,str1);
        // System.out.println(deletion(str));
        System.out.println(skipstring(str));
    }
    public static void deletion(String str,String str1){
        if(str.isEmpty()){
            System.out.println(str1);
            return;
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            deletion(str.substring(1),str1);
        }
        else {
            deletion(str.substring(1),str1 + ch);
        }
    }

    public static String deletion(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            return deletion(str.substring(1));
        }
        else {
           return ch + deletion(str.substring(1));
        }
    }


    public static String skipstring(String str){
        if(str.isEmpty()){
            return "";
        }


        if(str.startsWith("ki") && !str.startsWith("kiwi")){
            return skipstring(str.substring(2));
        }
        else {
            return str.charAt(0)+ skipstring(str.substring(1));
        }
    }
}

