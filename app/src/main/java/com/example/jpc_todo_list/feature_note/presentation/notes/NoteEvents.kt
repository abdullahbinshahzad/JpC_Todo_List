package com.example.jpc_todo_list.feature_note.presentation.notes

import com.example.jpc_todo_list.feature_note.domain.model.Note
import com.example.jpc_todo_list.feature_note.domain.util.OrderBy

sealed class NoteEvents {
    data class Order(val orderBy: OrderBy): NoteEvents()
    data class DeleteNote(val note: Note): NoteEvents()

    object RestoreNote: NoteEvents()
    object ToggleOrderSection: NoteEvents()
}