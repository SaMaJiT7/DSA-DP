package Leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class robot_walk_II {
//    int[][] grid;
//    int x;
//    int y;
//    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}}; // East,North,West,South
//    String[] direction = {"East","North","West","South"};
//    int d;
//    int perimeter;
//    public robot_walk_II(int width, int height) {
//        this.grid = new int[height][width];
//        this.x = 0;
//        this.y = 0;
//        this.d = 0;
//        this.perimeter = (2 * (width + height) - 4);
//    }
//
//    public void step(int num) {
//        if(num % perimeter == 0 && num > 0) {
//            num = perimeter;
//        }
//        else {
//            num = num % perimeter;
//        }
//        for(int i = 0; i < num; i++){
//            int nx = x + dir[d][0];
//            int ny = y + dir[d][1];
//
//           while(nx < 0 || nx >= grid[0].length  || ny < 0 || ny >= grid.length){
//                d = (d + 1) % 4;
//                nx = x + dir[d][0];
//                ny = y + dir[d][1];
//            }
//           x = nx;
//           y = ny;
//        }
//    }
//
//    public int[] getPos() {
//        return new int[]{x,y};
//    }
//
//    public String getDir() {
//        return direction[d];
//    }

//    int[][] grid;
//    boolean moved = false;
//    int idx;
//    String[] direction = {"East","North","West","South"};
//    List<int[]> pos = new ArrayList<>();
//    //East - 0
//    //North - 1
//    // West - 2
//    // South - 3
//    public Robot(int width, int height) {
//        this.grid = new int[height][width];
//        int perimeter = (2 * (width+height) - 4);
//        //Bottom Row
//        for(int x = 0; x < width; x++){
//            pos.add(new int[]{x,0,0});
//        }
//        //Right Col
//        for(int y = 1; y < height; y++){
//            pos.add(new int[]{width-1,y,1});
//        }
//        //top row
//        for(int x = width-2; x >= 0; x--){
//            pos.add(new int[]{x,height-1,2});
//        }
//        //Left Col
//        for(int y = height-2; y > 0; y--){
//            pos.add(new int[]{0,y,3});
//        }
//        pos.get(0)[2] = 3;
//    }
//
//    public void step(int num) {
//        moved = true;
//        idx = (idx + num) % pos.size();
//    }
//
//    public int[] getPos() {
//        return new int[]{pos.get(idx)[0],pos.get(idx)[1]};
//    }
//
//    public String getDir() {
//        if(!moved) return "East";
//        return direction[pos.get(idx)[2]];
//    }
}
