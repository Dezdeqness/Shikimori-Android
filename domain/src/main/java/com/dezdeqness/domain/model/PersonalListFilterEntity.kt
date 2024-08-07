package com.dezdeqness.domain.model

data class PersonalListFilterEntity(
    val sort: Sort,
) {
    companion object {
        fun createFilter(sort: String): PersonalListFilterEntity {
            return PersonalListFilterEntity(
                sort = Sort.fromString(sort),
            )
        }
    }
}

enum class Sort(val sort: String) {
    NAME("name"),
    PROGRESS("progress"),
    SCORE("score"),
    EPISODES("episodes"),
    ADDED_TIME("added_time"),
    UPDATED_TIME("updated_time");

    companion object {
        fun fromString(value: String) = entries.find { it.sort == value } ?: NAME
    }
}
