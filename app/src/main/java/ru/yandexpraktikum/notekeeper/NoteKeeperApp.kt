package ru.yandexpraktikum.notekeeper

import android.app.Application
import ru.yandexpraktikum.notekeeper.di.AppContainer

class NoteKeeperApp: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}