package com.msimic.codingchallenge1und1.util


/**
 * Convert String to a IntRange, that represents the 5 digit postal code. Only 5 digit Strings can
 * be converted.
 *
 * Example:
 *
 * 12345 -> IntRange(12345, 12345)
 *
 * 123* -> IntRange(12300, 12399)
 *
 * @return an IntRange representing the working area.
 */
fun String.convertAreaToRange(): IntRange = when (this.length) {
    5 -> IntRange(this.toInt(), this.toInt())
    0 -> IntRange(0, 99999)
    else -> {
        val start = this.padEnd(5, '0')
        val end = this.padEnd(5, '9')
        IntRange(start.toInt(), end.toInt())
    }
}

/**
 * Check whether the there is an overlap between two IntRanges.
 *
 * @param other IntRange to compare
 * @return true if any value from other is in this IntRange
 */
fun IntRange.inIntRange(other: IntRange): Boolean =
    this.contains(other.first) || other.contains(this.first)