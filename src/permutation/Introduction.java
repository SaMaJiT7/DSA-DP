package permutation;

import java.util.ArrayList;

public class Introduction {
    public static void main(String[] args) {
        //System.out.println(countpath(3,3));
       // path("",3,3);
       // System.out.println(pathdiagonal("",3,3));
        boolean[][] board = {
                {true,true,true},{true,false,true},{true,true,true}
        };
        pathRestriction("",board,0,0);
    }
    static int countpath(int r , int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int count = 0;
        int left = countpath(r-1,c);
        int right = countpath(r,c-1);
        return left + right;
    }
    public static void path(String p , int r , int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return ;
        }
        if(r > 1){
            path(p+"D", r-1,c);
        }
        if(c > 1){
            path(p+"R",r,c-1);
        }
    }

    public static ArrayList<String> path1(String p , int r , int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r > 1){
            list.addAll(path1(p+"D", r-1,c));
        }
        if(c > 1){
            list.addAll(path1(p+"R",r,c-1));
        }
        return list;
    }
    public static ArrayList<String> pathdiagonal(String p , int r , int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r > 1){
            list.addAll(pathdiagonal(p+"D", r-1,c));
        }
        if(c > 1){
            list.addAll(pathdiagonal(p+"R",r,c-1));
        }
        if(c > 1 && r > 1){
            list.addAll(pathdiagonal(p+"d",r-1,c-1));
        }

        return list;
    }
    public static void pathRestriction(String p , boolean[][] maze,int r , int c){
        if(r == maze.length -1 && c == maze[0].length-1){
            System.out.println(p);
            return ;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length -1){
            pathRestriction(p+"D",maze,r+1,c);
        }
        if(c < maze[0].length-1){
            pathRestriction(p+"R",maze,r,c+1);
        }
    }
}