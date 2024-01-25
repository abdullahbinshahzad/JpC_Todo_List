package com.example.jpc_todo_list.feature_note.presentation.notes

import com.example.jpc_todo_list.feature_note.domain.model.Note
import com.example.jpc_todo_list.feature_note.domain.util.OrderBy
import com.example.jpc_todo_list.feature_note.domain.util.OrderType

data class NoteState(
    val note: List<Note> = emptyList(),
    val orderBy: OrderBy = OrderBy.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
    )
