package ru.yandexpraktikum.notekeeper.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.yandexpraktikum.notekeeper.data.local.model.NoteEntity

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    @Update
    suspend fun update(note: NoteEntity): Int

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteEntity?
}