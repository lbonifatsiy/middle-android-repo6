package ru.yandexpraktikum.all_notes.di

import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractorImpl
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractorImpl
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModelFactory
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper


class AllNotesContainer(
    private val repository: NotesRepository,
    private val presentationMapper: PresentationNoteMapper
) {

    private val fetchAllNotesInteractor by lazy {
        FetchAllNotesInteractorImpl(repository)
    }

    private val deleteNoteInteractor by lazy {
        DeleteNoteInteractorImpl(repository)
    }

    fun getAllNotesViewModelFactory() = AllNotesViewModelFactory(
        fetchAllNotesInteractor,
        deleteNoteInteractor,
        presentationMapper
    )
}