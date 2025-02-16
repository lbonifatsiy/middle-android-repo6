package ru.yandexpraktikum.notekeeper.data.local.repository

import kotlinx.coroutines.flow.Flow
import ru.yandexpraktikum.notekeeper.data.local.datasource.NoteLocalDataSource
import ru.yandexpraktikum.notekeeper.domain.repository.NoteRepository
import ru.yandexpraktikum.notekeeper.domain.model.Note


/**
 * TODO("Add documentation")
 */
class NoteRepositoryImpl(
    private val localDataSource: NoteLocalDataSource
): NoteRepository {
    override suspend fun insertNote(note: Note) = localDataSource.insertNote(note)
    override suspend fun deleteNote(note: Note) = localDataSource.deleteNote(note)
    override suspend fun updateNote(note: Note) = localDataSource.updateNote(note)
    override fun getAllNotes(): Flow<List<Note>> = localDataSource.getAllNotes()
    override suspend fun getNoteById(id: Int) = localDataSource.getNoteById(id)
}