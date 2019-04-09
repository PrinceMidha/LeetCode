package com.algo.kotlin.BoatsToSavePeople

fun main() {
    print(boatToSavePeople(arrayOf(3,2,2,1),3))
}

fun boatToSavePeople(people : Array<Int>, limit : Int): Int {
    var totalBoats = 0

    people.sort()

    var lightPersonIndex = 0
    var heaviestPersonIndex = people.lastIndex
    while (lightPersonIndex <= heaviestPersonIndex) {
        totalBoats++
        if (people[lightPersonIndex] + people[heaviestPersonIndex] <= limit) {
            lightPersonIndex++
        }
        heaviestPersonIndex --
    }
    return totalBoats
}
