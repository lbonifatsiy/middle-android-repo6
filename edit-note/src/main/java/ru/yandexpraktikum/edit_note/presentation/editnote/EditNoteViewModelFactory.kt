package ru.yandexpraktikum.edit_note.presentation.editnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.edit_note.domain.interactors.DeleteNoteInteractor
import ru.yandexpraktikum.edit_note.domain.interactors.FetchNoteByIdInteractor
import ru.yandexpraktikum.edit_note.domain.interactors.UpdateNoteInteractor

class EditNoteViewModelFactory(
    private val fetchNoteByIdInteractor: FetchNoteByIdInteractor,
    private val updateNoteInteractor: UpdateNoteInteractor,
    private val deleteNoteInteractor: DeleteNoteInteractor,
    private val noteMapper: PresentationNoteMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EditNoteViewModel(
                fetchNoteByIdInteractor,
                updateNoteInteractor,
                deleteNoteInteractor,
                noteMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}