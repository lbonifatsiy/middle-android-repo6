package ru.yandexpraktikum.all_notes.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.yandexpraktikum.all_notes.R
import ru.yandexpraktikum.core.presentation.model.NoteUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllNotesScreen(
    modifier: Modifier = Modifier,
    onAddNoteClick: () -> Unit,
    viewModel: AllNotesViewModel
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val notes by viewModel.allNotes.collectAsState(initial = emptyList())
    var showDialog by remember { mutableStateOf(false) }
    var noteToDelete: NoteUi? by remember { mutableStateOf(null) }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.all_notes)) })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNoteClick) {
                Icon(Icons.Filled.Add, stringResource(R.string.add))
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            NotesList(
                notes = notes,
                onDeleteClick = { note ->
                    noteToDelete = note
                    showDialog = true
                }
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(R.string.delete)) },
            text = { Text(stringResource(R.string.delete_note_question)) },
            confirmButton = {
                TextButton(onClick = {
                    noteToDelete?.let { note ->
                        viewModel.deleteNote(note)
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                "Note deleted successfully!"
                            )
                        }
                    }
                    showDialog = false
                }) {
                    Text(stringResource(R.string.delete))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(R.string.cancel))
                }
            }
        )
    }
}

@Composable
fun NotesList(
    notes: List<NoteUi>,
    onDeleteClick: (NoteUi) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(notes) { note ->
            NoteItem(
                note = note,
                onDeleteClick = onDeleteClick
            )
        }
    }
}

@Composable
fun NoteItem(
    note: NoteUi,
    onDeleteClick: (NoteUi) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.inversePrimary)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Text(text = note.content, style = MaterialTheme.typography.bodyMedium)
        }
        IconButton(onClick = { onDeleteClick(note) }) {
            Icon(Icons.Filled.Delete, stringResource(R.string.delete))
        }
    }
}
