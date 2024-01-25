package com.example.jpc_todo_list.feature_note.domain.use_case

import com.example.jpc_todo_list.feature_note.domain.model.Note
import com.example.jpc_todo_list.feature_note.domain.repository.NoteRepository

class DeleteNotes(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        noteRepository.deleteNote(note)
    }
}