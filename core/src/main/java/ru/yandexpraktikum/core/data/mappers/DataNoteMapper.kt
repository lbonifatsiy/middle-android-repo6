package ru.yandexpraktikum.core.data.mappers

import ru.yandexpraktikum.core.data.model.NoteEntity
import ru.yandexpraktikum.core.domain.model.Note
import javax.inject.Inject

class DataNoteMapper @Inject constructor() {
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