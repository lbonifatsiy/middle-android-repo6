package ru.yandexpraktikum.edit_note.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository

class UpdateNoteInteractorImpl(
    private val repository: NotesRepository
): UpdateNoteInteractor {
    override suspend fun invoke(note: Note) {
        repository.updateNote(note)
    }
}