package Hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class destination_city {
    public String destCity(List<List<String>> paths) {
//        HashSet<String> path = new HashSet<>();
//        for(int i = 0; i < paths.size(); i++){
//            String src = paths.get(i).get(0);
//            path.add(src);
//        }
//        for(int i = 0; i < paths.size(); i++){
//            String dest = paths.get(i).get(1);
//            if(!path.contains(dest)){
//                return dest;
//            }
//        }
//        return "";
        HashMap<String,Integer> way = new HashMap<>();
        for(List<String> path: paths){
            String src = path.get(0);
            String dest = path.get(1);
            way.put(src,1);
            if(!way.containsKey(dest)) way.put(dest,0);
        }
        for(List<String> path: paths){
            String dest = path.get(1);
            if(way.get(dest) == 0){
                return dest;
            }
        }
        return "";
    }
}
