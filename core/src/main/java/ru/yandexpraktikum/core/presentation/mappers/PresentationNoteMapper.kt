package ru.yandexpraktikum.core.presentation.mappers

import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.presentation.model.NoteUi

class PresentationNoteMapper {
    fun mapToUi(note: Note): NoteUi {
        return NoteUi(
            id = note.id,
            title = note.title,
            content = note.content
        )
    }

    fun mapToDomain(note: NoteUi): Note {
        return Note(
            id = note.id,
            title = note.title,
            content = note.content
        )
    }
}