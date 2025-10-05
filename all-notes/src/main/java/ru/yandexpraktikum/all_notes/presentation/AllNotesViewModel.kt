package ru.yandexpraktikum.all_notes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractor
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.core.presentation.model.NoteUi
import javax.inject.Inject

@HiltViewModel
class AllNotesViewModel @Inject constructor(
    fetchAllNotesInteractor: FetchAllNotesInteractor,
    private val deleteNoteInteractor: DeleteNoteInteractor,
    private val noteMapper: PresentationNoteMapper
) : ViewModel() {

    val allNotes = fetchAllNotesInteractor().map { list ->
        list.map { noteMapper.mapToUi(it) }
    }

    fun deleteNote(note: NoteUi) {
        viewModelScope.launch {
            deleteNoteInteractor(
                noteMapper.mapToDomain(note)
            )
        }
    }
}