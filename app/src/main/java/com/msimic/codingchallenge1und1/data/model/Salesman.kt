package com.msimic.codingchallenge1und1.data.model

import com.msimic.codingchallenge1und1.util.convertAreaToRange
import com.msimic.codingchallenge1und1.util.inIntRange

data class Salesman(
    val name: String,
    val areas: List<String>,
) {
    val areasString: String
        get() = areas.joinToString(", ")

    fun isResponsibleForArea(area: String): Boolean {
        val intRangeArea = area.replace("*", "").convertAreaToRange()
        return areas.any { responsibleArea ->
            if (responsibleArea.last() == '*') {
                val responsibleIntRangeArea = responsibleArea.replace("*", "").convertAreaToRange()
                intRangeArea.inIntRange(responsibleIntRangeArea)
            } else {
                intRangeArea.contains(responsibleArea.toInt())
            }
        }
    }
}
