public class patern {
    public static void main(String[] args) {
        int rows = 5;

        // first loop is for printing the rows
        for (int i = 0; i < rows; i++) {

            // loop for printing leading whitespaces
            for (int j = 0; j < 2 * (rows - i) - 1; j++) {
                System.out.println("");
            }

            // loop for printing * character
            for (int k = 0; k <= i; k++) {
                System.out.println(" *");
            }
            System.out.print("\n");
        }
    }
}
