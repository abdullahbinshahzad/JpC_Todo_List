package com.example.jpc_todo_list.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jpc_todo_list.ui.theme.BrightRed
import com.example.jpc_todo_list.ui.theme.Cyan
import com.example.jpc_todo_list.ui.theme.ElectricPurple
import com.example.jpc_todo_list.ui.theme.Yellow
import com.example.jpc_todo_list.ui.theme.YellowGreen


// todo this should be in data class and here mapper should be used
@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val title: String,
    val description: String,
    val timeStamp: Long,
    val color: Int
){
    companion object{
        val noteColor = listOf(ElectricPurple, YellowGreen, Cyan, Yellow, BrightRed)
    }
}
class InvalidNoteException(message: String): Exception(message)     //custom class for invalid note exception handling