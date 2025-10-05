package ru.yandexpraktikum.all_notes.domain.interactors

import kotlinx.coroutines.flow.Flow
import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import javax.inject.Inject

internal class FetchAllNotesInteractorImpl @Inject constructor(
    private val repository: NotesRepository
) : FetchAllNotesInteractor {
    override fun invoke(): Flow<List<Note>> {
        return repository.getAllNotes()
    }
}