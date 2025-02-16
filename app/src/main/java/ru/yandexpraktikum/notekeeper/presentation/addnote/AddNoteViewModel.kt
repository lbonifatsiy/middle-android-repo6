package ru.yandexpraktikum.notekeeper.presentation.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.yandexpraktikum.notekeeper.domain.repository.NoteRepository
import ru.yandexpraktikum.notekeeper.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.notekeeper.presentation.model.NoteUi

/**
 * TODO("Add documentation")
 */
class AddNoteViewModel(
    private val noteRepository: NoteRepository,
    private val noteMapper: PresentationNoteMapper
): ViewModel() {

    fun insertNote(note: NoteUi) {
        viewModelScope.launch {
            noteRepository.insertNote(noteMapper.mapToDomain(note))
        }
    }
}