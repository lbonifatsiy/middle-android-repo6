package ru.yandexpraktikum.notekeeper.presentation.allnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.yandexpraktikum.notekeeper.domain.repository.NoteRepository
import ru.yandexpraktikum.notekeeper.presentation.mappers.PresentationNoteMapper

class AllNotesViewModelFactory(
    private val noteRepository: NoteRepository,
    private val noteMapper: PresentationNoteMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllNotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AllNotesViewModel(noteRepository, noteMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}