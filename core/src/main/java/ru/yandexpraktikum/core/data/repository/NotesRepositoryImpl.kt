package ru.yandexpraktikum.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.yandexpraktikum.core.data.db.NoteDao
import ru.yandexpraktikum.core.data.mappers.DataNoteMapper
import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import javax.inject.Inject

internal class NotesRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao,
    private val noteMapper: DataNoteMapper
) : NotesRepository {
    override suspend fun insertNote(note: Note) {
        return noteDao.insert(
            noteMapper.mapToEntity(note)
        )
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.delete(
            noteMapper.mapToEntity(note)
        )
    }

    override suspend fun updateNote(note: Note): Int {
        return noteDao.update(
            noteMapper.mapToEntity(note)
        )
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { list ->
            list.map { noteMapper.mapToDomain(it) }
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)?.let {
            noteMapper.mapToDomain(it)
        }
    }
}