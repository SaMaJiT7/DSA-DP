package Leetcode_daily;

public class angleClock {
        public double angleClock(int hour, int minutes) {
            double hourangle = 30 * hour;
            double minutesangle = minutes * 6;
            hourangle += minutes * 0.5;
            double anglebw = Math.abs(minutesangle - hourangle);
            return Math.min(anglebw,360.0-anglebw);
        }
}
