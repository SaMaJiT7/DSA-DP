package Greedy;

public class station_gas {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Brute Force
//        int n = gas.length;
//        if(n != cost.length) return -1;
//        int startidx = 0;
//        int currentfuel = 0;
//        for(int i = 0; i < n; i++){
//            currentfuel = gas[i];
//            if(currentfuel < cost[i]){
//                continue;
//            }
//            else{
//               int j = (i+1)%n;
//               currentfuel = currentfuel - cost[i] + gas[j];
//               while(j != i){
//                   if(currentfuel < cost[j]){
//                       break;
//                   }
//                   int costfromj = cost[j];
//                   j = (j+1)%n;
//                   int gasearnedatj = gas[j];
//                   currentfuel = currentfuel - costfromj + gasearnedatj;
//
//               }
//               if(j == i) return i;
//            }
//        }
//        return -1;
        int n = gas.length;
        int totalgas = 0;
        int totalcost = 0;
        for(int i = 0; i < n; i++){
            totalcost += cost[i];
            totalgas += gas[i];
        }
        if(totalgas < totalcost) return -1;

        int totalfuel = 0;
        int i = 0;
        int result = 0;
        while(i < n){
            totalfuel = totalfuel + gas[i] - cost[i];
            if(totalfuel < 0){
                totalfuel = 0;
                result = i+1;
            }
            i++;
        }
        return result;
    }
}
