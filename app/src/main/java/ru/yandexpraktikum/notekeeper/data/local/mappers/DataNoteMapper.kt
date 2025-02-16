package ru.yandexpraktikum.notekeeper.data.local.mappers

import ru.yandexpraktikum.notekeeper.data.local.model.NoteEntity
import ru.yandexpraktikum.notekeeper.domain.model.Note

/**
 * TODO("Add documentation")
 */
class DataNoteMapper {
    fun mapToDomain(note: NoteEntity): Note {
        return Note(
            id = note.id,
            title = note.title,
            content = note.content
        )
    }

    fun mapToEntity(note: Note): NoteEntity {
        return NoteEntity(
            id = note.id,
            title = note.title,
            content = note.content
        )
    }

}