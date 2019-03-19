package com.algo.kotlin

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(list: Array<String>) {

    groupAnagram(arrayOf("are", "bat", "ear", "code", "tab", "era"))
}

fun groupAnagram(list: Array<String>) {

    if (list.isNullOrEmpty()) {
        return
    }

    var map = HashMap<String,ArrayList<String>>()
    list.forEach {
        var chars = it.toCharArray()
        Arrays.sort(chars)
        var key = String(chars)
        if (!map.containsKey(key)) {
            map.put(key,ArrayList())
        }
        map.get(key)?.add(it)
    }
    println(map.values)
}