package com.example.jpc_todo_list.feature_note.presentation.notes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jpc_todo_list.feature_note.presentation.notes.components.NoteItem
import com.example.jpc_todo_list.feature_note.presentation.notes.components.OrderSection
import com.example.jpc_todo_list.feature_note.presentation.util.Screen
import com.example.jpc_todo_list.ui.theme.JpC_Todo_ListTheme
import kotlinx.coroutines.launch

@Composable
fun NoteScreen(
    navController: NavController,
    viewModel: NoteViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          navController.navigate(Screen.AddEditNoteScreen.route)
                },
                modifier = Modifier.padding(10.dp),
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your Note",
                    style = MaterialTheme.typography.titleLarge
                )
                IconButton(
                    onClick = {
                        viewModel.onEvent(NoteEvents.ToggleOrderSection)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDownward,
                        contentDescription = "Sort"
                    )
                }
            }
            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                OrderSection(
                    modifier = Modifier
                        .padding(vertical = 16.dp),
                    orderBy = state.orderBy,
                    onOrderChange = {
                        viewModel.onEvent(NoteEvents.Order(it))
                    }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(items = state.note){notes ->
                    NoteItem(
                        note = notes,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(Screen.AddEditNoteScreen.route +
                                            "?noteId = ${notes.id} & ?noteTitle = ${notes.title}  & noteColor = ${notes.color}"
                                )
                            },
                        onDeleteSlideLeft = {
                            viewModel.onEvent(NoteEvents.DeleteNote(notes))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Note Deleted",
                                    actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed){
                                    viewModel.onEvent(NoteEvents.RestoreNote)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
@Preview
@Composable
fun NoteScreenPreview() {
    JpC_Todo_ListTheme {
        NoteScreen(navController = rememberNavController())
    }
}