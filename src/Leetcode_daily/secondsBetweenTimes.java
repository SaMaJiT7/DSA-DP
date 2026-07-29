package Leetcode_daily;

public class secondsBetweenTimes {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] time1 = startTime.split(":");
        String[] time2 = endTime.split(":");

        int totalsecondsfromt1 = 0;
        totalsecondsfromt1 += Integer.parseInt(time1[0]) * 3600;
        totalsecondsfromt1 += Integer.parseInt(time1[1]) * 60;
        totalsecondsfromt1 += Integer.parseInt(time1[2]);

        int totalsecondsfromt2 = 0;
        totalsecondsfromt2 += Integer.parseInt(time2[0]) * 3600;
        totalsecondsfromt2 += Integer.parseInt(time2[1]) * 60;
        totalsecondsfromt2 += Integer.parseInt(time2[2]);

        int secondDiff = totalsecondsfromt2 - totalsecondsfromt1;

        return secondDiff;
    }
}
