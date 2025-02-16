package ru.yandexpraktikum.notekeeper.presentation.allnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.yandexpraktikum.notekeeper.domain.repository.NoteRepository
import ru.yandexpraktikum.notekeeper.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.notekeeper.presentation.model.NoteUi

class AllNotesViewModel(
    private val noteRepository: NoteRepository,
    private val noteMapper: PresentationNoteMapper
): ViewModel() {

    val allNotes = noteRepository.getAllNotes().map { list ->
        list.map { noteMapper.mapToUi(it) }
    }

    fun deleteNote(note: NoteUi) {
        viewModelScope.launch {
            noteRepository.deleteNote(
                noteMapper.mapToDomain(note))
        }
    }
}