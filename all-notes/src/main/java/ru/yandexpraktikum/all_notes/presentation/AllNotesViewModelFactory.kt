package ru.yandexpraktikum.all_notes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractor
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper

class AllNotesViewModelFactory(
    private val fetchAllNotesInteractor: FetchAllNotesInteractor,
    private val deleteNoteInteractor: DeleteNoteInteractor,
    private val noteMapper: PresentationNoteMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllNotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AllNotesViewModel(fetchAllNotesInteractor, deleteNoteInteractor, noteMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}