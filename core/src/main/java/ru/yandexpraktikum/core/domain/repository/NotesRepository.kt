package ru.yandexpraktikum.core.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.yandexpraktikum.core.domain.model.Note

interface NotesRepository {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun updateNote(note: Note): Int
    fun getAllNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
}