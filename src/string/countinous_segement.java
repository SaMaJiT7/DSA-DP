package string;

public class countinous_segement {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int total = 0;
        int count = 0;
        for(int i = 1; i < n; i++){
            int num = s.charAt(i) - '0';
            if(num == 1) count++;
            if(num == 0 && s.charAt(i-1)-'0' == 1){
                total += 1;
                count = 0;
            }
        }
        if(count > 0) total +=1;
        return total <= 1;
    }
}
