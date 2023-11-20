package com.msimic.codingchallenge1und1.util


fun String.convertAreaToRange(): IntRange = when (this.length) {
    5 -> IntRange(this.toInt(), this.toInt())
    0 -> IntRange(0, 99999)
    else -> {
        val start = this.padEnd(5, '0')
        val end = this.padEnd(5, '9')
        IntRange(start.toInt(), end.toInt())
    }
}

fun IntRange.inIntRange(other: IntRange): Boolean =
    this.contains(other.first) || other.contains(this.first)