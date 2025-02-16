package ru.yandexpraktikum.notekeeper.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.yandexpraktikum.notekeeper.domain.model.Note

/**
 * TODO("Add documentation")
 */
interface NoteRepository {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun updateNote(note: Note): Int
    fun getAllNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
}