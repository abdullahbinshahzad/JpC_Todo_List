package com.example.jpc_todo_list.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jpc_todo_list.ui.theme.colorBlue
import com.example.jpc_todo_list.ui.theme.colorGreen
import com.example.jpc_todo_list.ui.theme.colorRed
import com.example.jpc_todo_list.ui.theme.colorViolet
import com.example.jpc_todo_list.ui.theme.colorBabyBlue

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val title: String,
    val description: String,
    val timeStamp: Long,
    val color: Int
){
    companion object{
        val noteColor = listOf(colorRed, colorViolet, colorBlue, colorGreen, colorBabyBlue)
    }
}
class InvalidNoteException(message: String): Exception(message)