package ru.yandexpraktikum.all_notes.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import javax.inject.Inject

internal class DeleteNoteInteractorImpl @Inject constructor(
    private val repository: NotesRepository
) : DeleteNoteInteractor {
    override suspend fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}