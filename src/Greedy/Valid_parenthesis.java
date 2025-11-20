package Greedy;

public class Valid_parenthesis {
    public boolean checkValidString(String s) {
        int n = s.length();
        int leftper = 0;
        int rightper = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                leftper = leftper + 1;
                rightper = rightper + 1;
            }
            else if(ch == ')'){
                leftper = leftper - 1;
                rightper = rightper - 1;
            }
            else{
                leftper = leftper - 1;
                rightper = rightper + 1;
            }

            if(leftper < 0){
                leftper = 0;
            }
            if(rightper < 0){
                return false;
            }
        }
        return (leftper == 0);
    }
}
