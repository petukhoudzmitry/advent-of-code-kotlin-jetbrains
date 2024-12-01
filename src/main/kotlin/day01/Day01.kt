package day01

import util.readInput
import kotlin.math.abs


fun part1(input: List<Int>) {
    check(input.size and 1 == 0)

    val firstList = input.filterIndexed { index, _ ->
        index and 1 == 0
    }.sorted()

    val secondList = input.filterIndexed { index, _ ->
        index and 1 == 1
    }.sorted()

    var distance = 0
    firstList.forEachIndexed { index, element ->
        distance += abs(secondList[index] - element)
    }


    println("Difference: $distance")
}


fun part2(input: List<Int>) {
    check(input.size and 1 == 0)

    val firstList = input.filterIndexed { index, _ ->
        index and 1 == 0
    }

    val secondList = input.filterIndexed { index, _ ->
        index and 1 == 1
    }

    val secondListFrequency = secondList.groupingBy { it }.eachCount()

    var similarityScore = 0

    firstList.forEach { element ->
        similarityScore += element * (secondListFrequency[element] ?: 0)
    }

    println("Similarity score: $similarityScore")
}


fun main() {
    val input = readInput("Day01").map {
        it.split("\\s+".toRegex())
    }.flatten().map {
        it.toInt()
    }

    part1(input)
    part2(input)
}