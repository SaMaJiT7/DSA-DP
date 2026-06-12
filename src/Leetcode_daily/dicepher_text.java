package Leetcode_daily;

public class dicepher_text {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        char[][] CharArr = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                CharArr[i][j] = encodedText.charAt(i * cols + j);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int col = 0; col < cols; col++){
            int i = 0;
            int j = col;
            while(i < rows && j < cols){
                ans.append(CharArr[i][j]);
                i++;
                j++;
            }
        }

        while(ans.length() > 0 && ans.charAt(ans.length()-1) == ' '){
            ans.deleteCharAt(ans.length()-1);
        }

        return ans.toString();
    }
}
