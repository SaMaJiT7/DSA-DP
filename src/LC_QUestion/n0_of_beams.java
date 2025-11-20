package LC_QUestion;

public class n0_of_beams {
    public int numberOfBeams(String[] bank) {
        int[] arr = new int[bank.length];
        for(int i = 0; i < bank.length;i++){
            int sum = 0;
            for(char ch : bank[i].toCharArray()){
                 sum  += ch - '0';
            }
            arr[i] = sum;
        }

        int count = 0;
        for (int num : arr) {
            if (num != 0) count++;
        }

// Create new array with only non-zero elements
        int[] newArr = new int[count];
        int index = 0;

        for (int num : arr) {
            if (num != 0) {
                newArr[index++] = num;
            }
        }

        int totalBeams = 0;
        for (int i = 0; i < newArr.length - 1; i++) {
            totalBeams += newArr[i] * newArr[i + 1];
        }

        return totalBeams;
    }
}
