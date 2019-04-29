package com.algo.kotlin.HappyNumber

fun main() {
    val number = 1055
    print("is $number a happy number : ${isHappyNumber(number)}")
}

fun isHappyNumber(value: Int): Boolean {
    var mainValue = value
    if (mainValue == 1) {
        return true
    } else if(mainValue < 10) {
        return false
    }
    var newValue = 0
    while (mainValue > 0) {
        newValue += (mainValue % 10) * (mainValue % 10)
        mainValue /= 10
    }
    return isHappyNumber(newValue)
}
