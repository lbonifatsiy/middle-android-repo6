package ru.yandexpraktikum.add_note.di

import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractorImpl
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModelFactory
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper


class AddNoteContainer(
    private val repository: NotesRepository,
    private val presentationNoteMapper: PresentationNoteMapper
) {

    private val addNoteInteractor by lazy {
        AddNoteInteractorImpl(repository)
    }

    fun getAddNoteViewModelFactory() = AddNoteViewModelFactory(
        addNoteInteractor,
        presentationNoteMapper
    )
}