package ru.yandexpraktikum.notekeeper.presentation.editnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.yandexpraktikum.notekeeper.domain.repository.NoteRepository
import ru.yandexpraktikum.notekeeper.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.notekeeper.presentation.model.NoteUi

class EditNoteViewModel(
    private val noteRepository: NoteRepository,
    private val noteMapper: PresentationNoteMapper
): ViewModel() {

    fun deleteNote(note: NoteUi) {
        viewModelScope.launch {
            noteRepository.deleteNote(
                noteMapper.mapToDomain(note))
        }
    }

    fun updateNote(note: NoteUi) {
        viewModelScope.launch {
            noteRepository.updateNote(noteMapper.mapToDomain(note))
        }
    }

    suspend fun getNoteById(id: Int): NoteUi? {
        return noteRepository.getNoteById(id)?.let {
            noteMapper.mapToUi(it)
        }
    }
}