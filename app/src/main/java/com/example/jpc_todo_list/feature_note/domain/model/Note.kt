package com.example.jpc_todo_list.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jpc_todo_list.ui.theme.BabyBlue
import com.example.jpc_todo_list.ui.theme.LightBlue
import com.example.jpc_todo_list.ui.theme.RedOrange
import com.example.jpc_todo_list.ui.theme.Violet

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val title: String,
    val description: String,
    val timeStamp: Long,
    val color: Int
){
    companion object{
        val noteColor = listOf(RedOrange, Violet, BabyBlue, LightBlue)
    }
}
class InvalidNoteException(message: String): Exception(message)