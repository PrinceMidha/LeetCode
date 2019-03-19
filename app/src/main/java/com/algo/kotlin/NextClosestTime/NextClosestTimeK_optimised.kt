package com.algo.kotlin.NextClosestTime


fun main(arr: Array<String>) {
    nextClosestTime("12:34")
}

fun nextClosestTime(time: String) {

    var elapse = 24 * 60
    var cur = time.subSequence(0, 2).toString().toInt() * 60
    cur +=  time.subSequence(3, time.length).toString().toInt()


    var timeDigits = HashSet<Int>()
    time.forEach {
        if (it.isDigit()) {
            timeDigits.add(it - '0')
        }
    }

    var candElapseTime = 0 //provided time - newTime ::: candElapseTIme should be less to be closest time
    var ans = 0
    for (h1 in timeDigits) {
        for (h2 in timeDigits) {
            if (h1 * 10 + h2 < 24) { //hrs must be less than 24 because there is never 24 hr... its 23:59 after that 00:00 rather than 24
                for (m1 in timeDigits) {
                    for (m2 in timeDigits) {
                        if (m1 * 10 + m2 < 60) { // same like hrs mins should be less than 60 as its always 11:59 after that 12:00
                            var newTime = (60 * (h1 * 10 + h2)) + (m1 * 10 + m2)
                            candElapseTime = Math.floorMod(newTime - cur,(24 * 60))
                            if (0 < candElapseTime && candElapseTime < elapse) {
                                ans = newTime
                                elapse = candElapseTime
                            }
                        }
                    }
                }
            }
        }
    }

    System.out.print("${ans / 60} : ${ans % 60}")
}