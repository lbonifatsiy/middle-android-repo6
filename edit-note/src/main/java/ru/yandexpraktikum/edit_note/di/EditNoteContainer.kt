package ru.yandexpraktikum.edit_note.di

import ru.yandexpraktikum.core.domain.repository.NotesRepository
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.edit_note.domain.interactors.DeleteNoteInteractorImpl
import ru.yandexpraktikum.edit_note.domain.interactors.FetchNoteByIdInteractorImpl
import ru.yandexpraktikum.edit_note.domain.interactors.UpdateNoteInteractorImpl
import ru.yandexpraktikum.edit_note.presentation.editnote.EditNoteViewModelFactory

class EditNoteContainer(
    private val repository: NotesRepository,
    private val presentationMapper: PresentationNoteMapper
) {
    private val fetchNoteByIdInteractor by lazy {
        FetchNoteByIdInteractorImpl(repository)
    }
    private val updateNoteInteractor by lazy {
        UpdateNoteInteractorImpl(repository)
    }
    private val deleteNoteInteractor by lazy {
        DeleteNoteInteractorImpl(repository)
    }

    fun getEditNoteViewModelFactory() = EditNoteViewModelFactory(
        fetchNoteByIdInteractor,
        updateNoteInteractor,
        deleteNoteInteractor,
        presentationMapper
    )
}