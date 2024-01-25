package com.example.jpc_todo_list.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jpc_todo_list.feature_note.domain.model.Note
import com.example.jpc_todo_list.feature_note.domain.use_case.NoteUseCases
import com.example.jpc_todo_list.feature_note.domain.util.OrderBy
import com.example.jpc_todo_list.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases

) : ViewModel() {

    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state

    private var recentlyDeletedNote: Note? = null
    private var getNotesJob: Job? = null

    init {
        getNotes(OrderBy.Date(OrderType.Descending))
    }
    fun onEvent(events: NoteEvents) {
        when (events) {
            is NoteEvents.Order -> {
                if (state.value.orderBy::class == events.orderBy::class &&
                    state.value.orderBy.orderType == events.orderBy.orderType
                ) {
                    return
                }
                getNotes(events.orderBy)
            }

            is NoteEvents.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNotes(events.note)
                    recentlyDeletedNote = events.note
                }
            }

            is NoteEvents.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NoteEvents.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(orderBy: OrderBy) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(orderBy)
            .onEach { notes ->
                _state.value = state.value.copy(
                    note = notes,
                    orderBy = orderBy
                )
            }
            .launchIn(viewModelScope)
    }
}