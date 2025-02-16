package ru.yandexpraktikum.notekeeper.data.local.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.yandexpraktikum.notekeeper.data.local.db.NoteDao
import ru.yandexpraktikum.notekeeper.data.local.mappers.DataNoteMapper
import ru.yandexpraktikum.notekeeper.domain.model.Note

/**
 * TODO("Add documentation")
 */
class NoteLocalDataSourceImpl(
    private val noteDao: NoteDao,
    private val noteMapper: DataNoteMapper
): NoteLocalDataSource {
    override suspend fun insertNote(note: Note) {
        return noteDao.insert(
            noteMapper.mapToEntity(note))
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.delete(
            noteMapper.mapToEntity(note))
    }

    override suspend fun updateNote(note: Note): Int {
        return noteDao.update(
            noteMapper.mapToEntity(note))
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