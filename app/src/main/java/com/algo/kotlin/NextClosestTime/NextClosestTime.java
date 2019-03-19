package com.algo.kotlin.NextClosestTime;

import java.util.HashSet;
import java.util.Set;


/*
    Problem
    Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
    You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

    Solution: Simulate the clock going forward by one minute. Each time it moves forward, if all the digits are allowed, then return the current time.
 */

public class NextClosestTime {

    public static void main(String[] args) {
        NextClosestTime closestnexttime = new NextClosestTime();
        System.out.println(closestnexttime.nextClosestTime("12:34"));
    }

    public String nextClosestTime(String time) {
        /*
        cur : to simulate clock going forward, we are converting total time to minutes, so that we can easily increase it by 1.
     */
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        /*
            timeDigits: separating the digits, to check in future if digits are matched with timeDigits because time generated should be created from the digits from given time
     */
        Set<Integer> allowed = new HashSet();
        for (char c : time.toCharArray())
            if (c != ':') {
                allowed.add(c - '0');
            }
            /*
            Infinite loop because we dont have any idea about at how many iterations closest time will come with same digits.
     */
        while (true) {
            //cur+1, adding 1 min to go forward from given time to find out closest time, always moving forward by 1 min and check everytime if it is from same timeDigits given.

            cur = (cur + 1) % (24 * 60);

            /*
            digits: getting hrs digit and min digits from generated time to match if same digits are present in provided time
         */
            int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search:
            {
                for (int d : digits) if (!allowed.contains(d)) break search;
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }
}
