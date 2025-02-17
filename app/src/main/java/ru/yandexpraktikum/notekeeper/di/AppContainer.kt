package ru.yandexpraktikum.notekeeper.di

import android.content.Context
import ru.yandexpraktikum.add_note.di.AddNoteContainer
import ru.yandexpraktikum.all_notes.di.AllNotesContainer
import ru.yandexpraktikum.core.di.CoreContainer
import ru.yandexpraktikum.edit_note.di.EditNoteContainer

class AppContainer(
    context: Context
) {

    private val coreContainer: CoreContainer by lazy {
        CoreContainer(context)
    }

    var allNotesContainer: AllNotesContainer? = null
    var editNoteContainer: EditNoteContainer? = null
    var addNoteContainer: AddNoteContainer? = null


    fun initAllNotesContainer() {
        allNotesContainer = AllNotesContainer(
            repository = coreContainer.repository,
            presentationMapper = coreContainer.presentationMapper
        )
    }

    fun initEditNoteContainer() {
        editNoteContainer = EditNoteContainer(
            repository = coreContainer.repository,
            presentationMapper = coreContainer.presentationMapper
        )
    }

    fun initAddNoteContainer() {
        addNoteContainer = AddNoteContainer(
            repository = coreContainer.repository,
            presentationNoteMapper = coreContainer.presentationMapper
        )
    }
}