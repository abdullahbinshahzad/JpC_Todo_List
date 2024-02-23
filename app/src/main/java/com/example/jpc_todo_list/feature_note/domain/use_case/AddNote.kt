package com.example.jpc_todo_list.feature_note.domain.use_case

import com.example.jpc_todo_list.feature_note.domain.model.InvalidNoteException
import com.example.jpc_todo_list.feature_note.domain.model.Note
import com.example.jpc_todo_list.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(private val noteRepository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("Title of the note can't be empty.")
        }
        if (note.description.isBlank()){
            throw InvalidNoteException("Description of the note can't be empty")
        }
        return noteRepository.insertNote(note)
    }
}