package ru.yandexpraktikum.edit_note.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository

class DeleteNoteInteractorImpl(
    private val repository: NotesRepository
): DeleteNoteInteractor {
    override suspend fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}