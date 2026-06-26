package binary_search;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Time_key_value {
    private static class TimeValue {
        String value;
        int timestamp;

        public TimeValue(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<TimeValue>> map;

    public Time_key_value() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(value,timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeValue> node = map.getOrDefault(key,null);
        if(node == null) return "";


        return SolveBS(node,timestamp);
    }

    public String SolveBS(List<TimeValue> history,int timestamp){
        int start = 0;
        int end = history.size()-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            TimeValue node = history.get(mid);

            if(node.timestamp == timestamp){
                return node.value;
            }
            else if(node.timestamp < timestamp){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        if(end >= 0){
            return history.get(end).value;
        }

        return "";
    }
}
