package ru.yandexpraktikum.add_note.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractor
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.core.presentation.model.NoteUi

class AddNoteViewModel(
    private val addNoteInteractor: AddNoteInteractor,
    private val noteMapper: PresentationNoteMapper
): ViewModel() {

    fun insertNote(note: NoteUi) {
        viewModelScope.launch {
            addNoteInteractor((noteMapper.mapToDomain(note)))
        }
    }
}