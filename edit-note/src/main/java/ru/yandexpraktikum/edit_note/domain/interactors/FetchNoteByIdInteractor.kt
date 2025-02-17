package ru.yandexpraktikum.edit_note.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note

interface FetchNoteByIdInteractor {
    suspend operator fun invoke(id: Int): Note?
}