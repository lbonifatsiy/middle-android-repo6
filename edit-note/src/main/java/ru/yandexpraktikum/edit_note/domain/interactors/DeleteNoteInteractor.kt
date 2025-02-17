package ru.yandexpraktikum.edit_note.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note

interface DeleteNoteInteractor {
    suspend operator fun invoke(note: Note)
}