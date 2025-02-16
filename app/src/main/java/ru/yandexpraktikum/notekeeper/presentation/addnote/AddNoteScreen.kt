package ru.yandexpraktikum.notekeeper.presentation.addnote;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.yandexpraktikum.notekeeper.NoteKeeperApp
import ru.yandexpraktikum.notekeeper.R
import ru.yandexpraktikum.notekeeper.presentation.model.NoteUi

import kotlin.OptIn;

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    addNoteViewModelFactory: AddNoteViewModelFactory = (androidx.compose.ui.platform.LocalContext.current.applicationContext as NoteKeeperApp).container.getAddNoteViewModelFactory(),
    viewModel: AddNoteViewModel = viewModel(factory = addNoteViewModelFactory)
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.add_note)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    innerPadding
                ),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text(stringResource(R.string.title)) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text(stringResource(R.string.content)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        val note = NoteUi(title = title, content = content)

                        viewModel.insertNote(note)
                        onBackClick()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.save))
                }
            }
        }
    }
}