package ru.yandexpraktikum.edit_note.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository

class FetchNoteByIdInteractorImpl(
    private val repository: NotesRepository
): FetchNoteByIdInteractor {
    override suspend fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}