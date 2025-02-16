package ru.yandexpraktikum.notekeeper.presentation.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.yandexpraktikum.notekeeper.domain.repository.NoteRepository
import ru.yandexpraktikum.notekeeper.presentation.mappers.PresentationNoteMapper

class AddNoteViewModelFactory(
    private val noteRepository: NoteRepository,
    private val noteMapper: PresentationNoteMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddNoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddNoteViewModel(noteRepository, noteMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}