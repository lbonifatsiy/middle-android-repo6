package ru.yandexpraktikum.notekeeper.di

import android.content.Context
import androidx.room.Room
import ru.yandexpraktikum.notekeeper.data.local.db.NoteDatabase
import ru.yandexpraktikum.notekeeper.data.local.datasource.NoteLocalDataSourceImpl
import ru.yandexpraktikum.notekeeper.data.local.repository.NoteRepositoryImpl
import ru.yandexpraktikum.notekeeper.data.local.mappers.DataNoteMapper
import ru.yandexpraktikum.notekeeper.presentation.addnote.AddNoteViewModelFactory
import ru.yandexpraktikum.notekeeper.presentation.mappers.PresentationNoteMapper
import ru.yandexpraktikum.notekeeper.presentation.allnotes.AllNotesViewModelFactory
import ru.yandexpraktikum.notekeeper.presentation.editnote.EditNoteViewModelFactory

private const val DATABASE_NAME = "note_database"
class AppContainer(
    context: Context
) {
    private val noteDatabase: NoteDatabase = Room.databaseBuilder(
        context.applicationContext,
        NoteDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val dataMapper = DataNoteMapper()

    private val noteLocalDataSource = NoteLocalDataSourceImpl(
        noteDatabase.noteDao(),
        dataMapper
    )
    private val noteRepository = NoteRepositoryImpl(noteLocalDataSource)

    private val presentationMapper = PresentationNoteMapper()

    fun getAllNotesViewModelFactory() = AllNotesViewModelFactory(
        noteRepository,
        presentationMapper
    )

    fun getAddNoteViewModelFactory() = AddNoteViewModelFactory(
        noteRepository,
        presentationMapper
    )

    fun getEditNoteViewModelFactory() = EditNoteViewModelFactory(
        noteRepository,
        presentationMapper
    )
}