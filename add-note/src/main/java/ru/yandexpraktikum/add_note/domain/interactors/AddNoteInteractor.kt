package ru.yandexpraktikum.add_note.domain.interactors

import ru.yandexpraktikum.core.domain.model.Note

interface AddNoteInteractor {
    suspend operator fun invoke(note: Note)
}