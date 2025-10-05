package ru.yandexpraktikum.add_note.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import javax.inject.Inject

internal class AddNoteInteractorImpl @Inject constructor(
    private val repository: NotesRepository
) : AddNoteInteractor {
    override suspend fun invoke(note: Note) {
        repository.insertNote(note)
    }
}