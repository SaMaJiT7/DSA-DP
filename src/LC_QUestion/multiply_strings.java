package LC_QUestion;

public class multiply_strings {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] answer = new int[m+n];

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mult + answer[p2];
                answer[p2] = sum % 10;
                answer[p1] += sum / 10;
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < answer.length; i++){
            if(i == 0 && answer[i] == 0) continue;
            str.append((char)(answer[i] + '0'));
        }

        return str.toString();
    }

}
