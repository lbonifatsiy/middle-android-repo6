package ru.yandexpraktikum.edit_note.presentation.editnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.core.presentation.model.NoteUi
import ru.yandexpraktikum.edit_note.domain.interactors.DeleteNoteInteractor
import ru.yandexpraktikum.edit_note.domain.interactors.FetchNoteByIdInteractor
import ru.yandexpraktikum.edit_note.domain.interactors.UpdateNoteInteractor

class EditNoteViewModel(
    private val fetchNoteByIdInteractor: FetchNoteByIdInteractor,
    private val updateNoteInteractor: UpdateNoteInteractor,
    private val deleteNoteInteractor: DeleteNoteInteractor,
    private val noteMapper: PresentationNoteMapper
): ViewModel() {

    fun deleteNote(note: NoteUi) {
        viewModelScope.launch {
            deleteNoteInteractor(
                noteMapper.mapToDomain(note))
        }
    }

    fun updateNote(note: NoteUi) {
        viewModelScope.launch {
            updateNoteInteractor(noteMapper.mapToDomain(note))
        }
    }

    suspend fun getNoteById(id: Int): NoteUi? {
        return fetchNoteByIdInteractor(id)?.let {
            noteMapper.mapToUi(it)
        }
    }
}