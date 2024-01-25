package com.example.jpc_todo_list.feature_note.domain.use_case

import com.example.jpc_todo_list.feature_note.domain.model.Note
import com.example.jpc_todo_list.feature_note.domain.repository.NoteRepository
import com.example.jpc_todo_list.feature_note.domain.util.OrderBy
import com.example.jpc_todo_list.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val noteRepository: NoteRepository) {

    operator fun invoke(orderBy: OrderBy = OrderBy.Date(OrderType.Descending)): Flow<List<Note>>{
        return noteRepository.getAllNote().map { notes ->
            when(orderBy.orderType){
                is OrderType.Ascending ->{
                    when(orderBy){
                        is OrderBy.Name-> notes.sortedBy { it.title.lowercase() }
                        is OrderBy.Date-> notes.sortedBy { it.timeStamp }
                        is OrderBy.Color-> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending ->{
                    when(orderBy){
                        is OrderBy.Name-> notes.sortedByDescending { it.title.lowercase() }
                        is OrderBy.Date-> notes.sortedByDescending { it.timeStamp }
                        is OrderBy.Color-> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}