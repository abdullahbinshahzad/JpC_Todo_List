package com.example.jpc_todo_list.feature_note.domain.use_case

import com.example.jpc_todo_list.feature_note.domain.model.Note
import com.example.jpc_todo_list.feature_note.domain.repository.NoteRepository

class GetSingleNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}