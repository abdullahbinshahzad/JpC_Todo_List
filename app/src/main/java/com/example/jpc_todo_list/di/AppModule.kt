package com.example.jpc_todo_list.di

import android.app.Application
import androidx.room.Room
import com.example.jpc_todo_list.feature_note.data.data_source.NoteDatabase
import com.example.jpc_todo_list.feature_note.data.repository.NoteRepositoryImpl
import com.example.jpc_todo_list.feature_note.domain.repository.NoteRepository
import com.example.jpc_todo_list.feature_note.domain.use_case.AddNote
import com.example.jpc_todo_list.feature_note.domain.use_case.DeleteNotes
import com.example.jpc_todo_list.feature_note.domain.use_case.GetNotes
import com.example.jpc_todo_list.feature_note.domain.use_case.GetSingleNote
import com.example.jpc_todo_list.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module  //indicating dagger hilt module
@InstallIn(SingletonComponent::class)//lifetime of dependencies
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): NoteDatabase{
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideUseCases(noteRepository: NoteRepository): NoteUseCases{
        return  NoteUseCases(
            getNotes = GetNotes(noteRepository),
            deleteNotes = DeleteNotes(noteRepository),
            addNote = AddNote(noteRepository),
            getSingleNote = GetSingleNote(noteRepository)
        )
    }
}