package LC_QUestion;

public class operations_easy {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i = 0; i < operations.length;i++){
            String op = operations[i];

            if(op.equals("++X") || op.equals("X++")){
                x = x + 1;
            }
            else if(op.equals("--X") || op.equals("X--")){
                x = x - 1;
            }
        }
        return x;
    }
}
