package ru.yandexpraktikum.notekeeper.presentation.mappers

import ru.yandexpraktikum.notekeeper.domain.model.Note
import ru.yandexpraktikum.notekeeper.presentation.model.NoteUi

/**
 * TODO("Add documentation")
 */
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