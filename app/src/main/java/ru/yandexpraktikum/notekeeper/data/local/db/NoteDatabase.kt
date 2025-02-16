package ru.yandexpraktikum.notekeeper.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.yandexpraktikum.notekeeper.data.local.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}