package ru.yandexpraktikum.notekeeper.di

import android.content.Context
import ru.yandexpraktikum.add_note.di.AddNoteContainer
import ru.yandexpraktikum.all_notes.di.AllNotesContainer
import ru.yandexpraktikum.core.di.CoreContainer

class AppContainer(
    context: Context
) {

    private val coreContainer: CoreContainer by lazy {
        CoreContainer(context)
    }

    private var allNotesContainer: AllNotesContainer? = null
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