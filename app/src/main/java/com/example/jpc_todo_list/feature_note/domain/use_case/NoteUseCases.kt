package com.example.jpc_todo_list.feature_note.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNotes: DeleteNotes,
    val addNote: AddNote
)
