package ru.yandexpraktikum.notekeeper.domain.model

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
)
