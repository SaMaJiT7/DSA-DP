package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        //System.out.println(Allpathdia("",3,3));
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];

        Allpathobst("", maze, 0, 0);
        Allpathprint("",maze,0,0);
        Allpathprint("",maze,0,0,path,1);
    }
    static int count(int r , int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int down = count(r-1,c);
        int right = count(r,c-1);
        return down + right;
    }

    public static ArrayList<String> Allpathdia(String p , boolean[][] maze, int r , int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(Allpathdia(p + "V", maze, r-1, c));
        }
        if (c > 1) {
            list.addAll(Allpathdia(p + "H", maze, r, c-1));
        }
        if (r > 1 && c > 1) {
            list.addAll(Allpathdia(p + "D", maze, r - 1, c - 1));
        }
        return list;
    }




    public static void Allpathobst(String p, boolean[][] maze, int r, int c) {
        // Base condition: Reached the bottom-right corner
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println("Path: " + p);
            return;
        }

        // If the current cell is blocked (false), return
        if (!maze[r][c]) {
            System.out.println("Blocked at (" + r + ", " + c + ")");
            return;
        }

        // Move Down if possible
        if (r < maze.length - 1) {
            Allpathobst(p + "D", maze, r + 1, c);
        }

        // Move Right if possible
        if (c < maze[0].length - 1) {
            Allpathobst(p + "R", maze, r, c + 1);
        }
    }

    public static void Allpathprint(String p, boolean[][] maze, int r, int c) {
        // Base condition: If we reach the bottom-right corner, print the path
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println("Path: " + p);
            return;
        }

        // Mark the current cell as visited
        maze[r][c] = false;

        // Explore all possible directions (Down, Right, Up, Left) if the cell is valid
        if (r < maze.length - 1 && maze[r + 1][c]) { // Move Down
            Allpathprint(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1 && maze[r][c + 1]) { // Move Right
            Allpathprint(p + "R", maze, r, c + 1);
        }
        if (r > 0 && maze[r - 1][c]) { // Move Up
            Allpathprint(p + "U", maze, r - 1, c);
        }
        if (c > 0 && maze[r][c - 1]) { // Move Left
            Allpathprint(p + "L", maze, r, c - 1);
        }

        // Unmark the current cell (backtrack) to allow other paths
        maze[r][c] = true;
    }
    public static void Allpathprint(String p, boolean[][] maze, int r, int c,int[][] path ,int step) {
        // Base condition: If we reach the bottom-right corner, print the path
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();

        }

        // Mark the current cell as visited
        maze[r][c] = false;
        path[r][c] = step;

        // Explore all possible directions (Down, Right, Up, Left) if the cell is valid
        if (r < maze.length - 1 && maze[r + 1][c]) { // Move Down
            Allpathprint(p + "D", maze, r + 1, c,path,step+1);
        }
        if (c < maze[0].length - 1 && maze[r][c + 1]) { // Move Right
            Allpathprint(p + "R", maze, r, c + 1,path,step+1);
        }
        if (r > 0 && maze[r - 1][c]) { // Move Up
            Allpathprint(p + "U", maze, r - 1, c,path,step+1);
        }
        if (c > 0 && maze[r][c - 1]) { // Move Left
            Allpathprint(p + "L", maze, r, c - 1,path,step+1);
        }

        // Unmark the current cell (backtrack) to allow other paths
        maze[r][c] = true;
        path[r][c] = 0;
    }

}
