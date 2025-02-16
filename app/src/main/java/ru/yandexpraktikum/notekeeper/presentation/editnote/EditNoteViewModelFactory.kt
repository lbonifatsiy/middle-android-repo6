package ru.yandexpraktikum.notekeeper.presentation.editnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.yandexpraktikum.notekeeper.domain.repository.NoteRepository
import ru.yandexpraktikum.notekeeper.presentation.mappers.PresentationNoteMapper

class EditNoteViewModelFactory(
    private val noteRepository: NoteRepository,
    private val noteMapper: PresentationNoteMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EditNoteViewModel(noteRepository, noteMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}