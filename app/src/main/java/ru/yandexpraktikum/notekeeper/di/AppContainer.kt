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

    private var allNotesContainer: AllNotesContainer? = null
    private var editNoteContainer: EditNoteContainer? = null
    private var addNoteContainer: AddNoteContainer? = null


    fun getAllNotesContainer(): AllNotesContainer? {
        if (allNotesContainer == null) {
            allNotesContainer = AllNotesContainer(
                repository = coreContainer.repository,
                presentationMapper = coreContainer.presentationMapper
            )
        }
        return allNotesContainer
    }

    fun releaseAllNotesContainer() {
        allNotesContainer = null
    }

    fun getEditNoteContainer(): EditNoteContainer? {
        if (editNoteContainer == null) {
            editNoteContainer = EditNoteContainer(
                repository = coreContainer.repository,
                presentationMapper = coreContainer.presentationMapper
            )
        }
        return editNoteContainer
    }

    fun releaseEditNoteContainer() {
        editNoteContainer = null
    }

    fun getAddNoteContainer(): AddNoteContainer? {
        if (addNoteContainer == null) {
            addNoteContainer = AddNoteContainer(
                repository = coreContainer.repository,
                presentationNoteMapper = coreContainer.presentationMapper
            )
        }
        return addNoteContainer
    }

    fun releaseAddNoteContainer() {
        addNoteContainer = null
    }
}