package ru.yandexpraktikum.all_notes.domain.interactors

import kotlinx.coroutines.flow.Flow
import ru.yandexpraktikum.core.domain.model.Note

interface FetchAllNotesInteractor {
    operator fun invoke(): Flow<List<Note>>
}