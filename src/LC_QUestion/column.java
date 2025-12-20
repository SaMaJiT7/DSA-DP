package LC_QUestion;

public class column {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int m = strs.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
