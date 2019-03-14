package com.algo.kotlin

/*
    Problem
    Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
    You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

    Solution: Simulate the clock going forward by one minute. Each time it moves forward, if all the digits are allowed, then return the current time.

    Example 1:
    Input: "19:34"
    Output: "19:39"
    Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.

    Example 2:
    Input: "23:59"
    Output: "22:22"
    Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

 */

fun main(args: Array<String>) {
    findNextClosestTime("12:34")
}

private fun findNextClosestTime(time: String) {

    /*
        totalMins : to simulate clock going forward, we are converting total time to minutes, so that we can easily increase it by 1.
     */
    var totalMins = time.subSequence(0, 2).toString().toInt().times(60)
    totalMins += time.subSequence(3, time.length).toString().toInt()

    /*
        timeDigits: separating the digits, to check in future if digits are matched with timeDigits because time generated should be created from the digits from given time
     */
    var timeDigits = HashSet<Int>()
    time.forEach {
        if (it.isDigit()) {
            timeDigits.add(it - '0')
        }
    }

    /*
        Infinite loop because we dont have any idea about at how many iterations closest time will come with same digits.
     */
    while (true) {
        //totalMins+1, adding 1 min to go forward from given time to find out closest time, always moving forward by 1 min and check everytime if it is from same timeDigits given.
        totalMins = (totalMins + 1) % (24 * 60)

        /*
            foundedDigits: getting hrs digit and min digits from generated time to match if same digits are present in provided time
         */
        var foundedDigits = intArrayOf((totalMins / 60 / 10), totalMins / 60 % 10,
                totalMins % 60 / 10, totalMins % 60 % 10)
        loop@ for (digit in foundedDigits) {
            if (!timeDigits.contains(digit)) {
                found = false
                break@loop
            }
            found = true
        }
        if (found) {
            break
        }
    }

    print("${totalMins / 60}:${totalMins % 60}")
}

var found: Boolean = false

