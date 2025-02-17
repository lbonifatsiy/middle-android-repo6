package ru.yandexpraktikum.core.di

import android.content.Context
import androidx.room.Room
import ru.yandexpraktikum.core.data.db.NoteDatabase
import ru.yandexpraktikum.core.data.mappers.DataNoteMapper
import ru.yandexpraktikum.core.data.repository.NotesRepositoryImpl
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper

private const val DATABASE_NAME = "note_database"

class CoreContainer(
    context: Context
) {
    private val noteDatabase: NoteDatabase = Room.databaseBuilder(
        context.applicationContext,
        NoteDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val dataMapper = DataNoteMapper()

    val presentationMapper = PresentationNoteMapper()

    val repository = NotesRepositoryImpl(
        noteDao = noteDatabase.noteDao(),
        noteMapper = dataMapper
    )
}