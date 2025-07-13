public class flippingimage {
    public static void main(String[] args) {
    }
    public int[][] flipAndInvertImage(int[][] image) {
        int l = image.length;
        int i = 0;
        int row = 0;
        while(i < l/2){
            int temp = image[row][i];
            image[row][i] = image[row][image.length-1-i];
            image[row][image.length-1-i] = temp;
            i++;
        }
        row++;

        for (int row2 = 0; row2 < image.length; row2++){
            for (int col = 0; col < image[row2].length ; col++){
                image[row2][col] = image[row2][col] ^ 1;
            }
        }
        return image;
    }
}
