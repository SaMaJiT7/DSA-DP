package Leetcode_daily;

import java.util.HashSet;

public class robot_walking {
    HashSet<String> set;
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        //char dir = 'N';
        int ans = 0;
        int n = commands.length;
        set = new HashSet<>();
        for(int[] val : obstacles) {
            int a = val[0];
            int b = val[1];
            set.add(a + "," + b);
        }

        //MY Approach using only if

//        for(int i = 0; i < n; i++){
//            if(commands[i] >= 1 && commands[i] <= 9){
//                for(int step = 0; step < commands[i]; step++){
//                    int nx = x , ny = y;
//
//                    if(dir == 'N'){
//                        ny = ny + 1;
//                    }else if(dir == 'E'){
//                        nx = nx + 1;
//                    }
//                    else if(dir == 'S'){
//                        ny = ny - 1;
//                    }
//                    else {
//                        nx = nx - 1;
//                    }
//
//                    if(obstacle_at(nx,ny)) break;
//
//                    x = nx;
//                    y = ny;
//                    ans = Math.max(ans,x*x+y*y);
//                }
//            }
//
//            else if(commands[i] == -1){
//                if(dir == 'N'){
//                    dir = 'E';
//                }
//                else if(dir == 'E'){
//                    dir = 'S';
//                }
//                else if(dir == 'S'){
//                    dir = 'W';
//                }
//                else{
//                    dir = 'N';
//                }
//            }
//
//            else{
//                if(dir == 'N'){
//                    dir = 'W';
//                }
//                else if(dir == 'E'){
//                    dir = 'N';
//                }
//                else if(dir == 'S'){
//                    dir = 'E';
//                }
//                else{
//                    dir = 'S';
//                }
//            }
//        }
//        return ans;



        //approach with better logic
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int d=0;
        for(int i = 0; i < n; i++){
            if(commands[i] == -2){ // Turning left 90 degree
                d = (d+3) % 4;
            }
            else if(commands[i] == -1){ // turning right 90
                d = (d+1) % 4;
            }
            else{
                for(int step = 0; step < commands[i]; i++){
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if(obstacle_at(nx,ny)) break;

                    x = nx;
                    y = ny;
                    ans = Math.max(ans,x*x+y*y);
                }
            }
        }
        return ans;
    }
    public boolean obstacle_at(int a,int b){
        String key = a + "," + b;
        if(set.contains(key)){
            return true;
        }
        return false;
    }
}
