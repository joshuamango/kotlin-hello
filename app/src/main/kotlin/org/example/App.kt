package org.example

import kotlinx.coroutines.*;

fun insertionSort(list: Array<Int>) {
    for (i in 0..list.size-2) {
        var min = i
        for (j in i+1..list.size-1) {
            if (list[min] > list[j]) {
                min = j
            }
        }
        if (min != i) {
            val temp = list[i]
            list[i] = list[min]
            list[min] = temp
        }
    }
}

fun bubbleSort(list: Array<Int>) {
    var done = false
    while (!done) {
        done = true;
        for (i in 0..list.size-2) {
            if (list[i] > list[i+1]) {
                done = false;
                val temp = list[i]
                list[i] = list[i+1]
                list[i+1] = temp
            }
        }
    }
}

fun main() = runBlocking {
	val list = Array<Int>(10000){ i -> 10000 - i }
	val list2 = Array<Int>(10000){ i -> 10000 - i }
    launch {
        insertionSort(list)
        println("insert")
    }
    launch {
	    bubbleSort(list2)
        println("bubble")
    }
    println("end")
}
