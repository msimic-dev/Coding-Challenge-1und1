package com.msimic.codingchallenge1und1.data.model

/**
 * TODO This is currently not in use. All instances of area should be using this value class
 *
 * @property value postal code expression
 */
@JvmInline
value class Area(val value: String) {
    private val getAsIntRange: IntRange
        get() {
            return when (this.value.length) {
                5 -> IntRange(this.value.toInt(), this.value.toInt())
                0 -> IntRange(0, 99999)
                else -> {
                    val start = this.value.padEnd(5, '0')
                    val end = this.value.padEnd(5, '9')
                    IntRange(start.toInt(), end.toInt())
                }
            }
        }

    init {
        val regex = Regex("^[0-9]{5}$|^[0-9]{1,4}\\*$")
        require(value.matches(regex))
    }
}