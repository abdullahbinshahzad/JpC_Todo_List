package com.example.jpc_todo_list.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jpc_todo_list.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase(){

    abstract val noteDao: NoteDao     //abstract property to access and manipulate Note entities

    companion object{     //define methods and properties that are associated with the class itself rather than with instances of the class.
        const val DATABASE_NAME = "note_table"
    }
}