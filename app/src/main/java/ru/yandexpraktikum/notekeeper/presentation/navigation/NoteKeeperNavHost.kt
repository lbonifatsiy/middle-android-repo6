package ru.yandexpraktikum.notekeeper.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.yandexpraktikum.add_note.presentation.AddNoteScreen
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModel
import ru.yandexpraktikum.all_notes.presentation.AllNotesScreen
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModel
import ru.yandexpraktikum.edit_note.presentation.editnote.EditNoteScreen
import ru.yandexpraktikum.edit_note.presentation.editnote.EditNoteViewModel
import ru.yandexpraktikum.notekeeper.di.AppContainer

private const val NOTE_ID = "noteId"

@Composable
fun NoteKeeperNavHost(
    appContainer: AppContainer,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AllNotes.route
    ) {
        composable(route = Screen.AllNotes.route) {
            var allNotesContainer by remember { mutableStateOf<Any?>(null) }
            DisposableEffect(Unit) {
                allNotesContainer = appContainer.getAllNotesContainer()
                onDispose {
                    appContainer.releaseAllNotesContainer()
                    allNotesContainer = null
                }
            }
            val vm: AllNotesViewModel = viewModel(factory = appContainer.getAllNotesContainer()?.getAllNotesViewModelFactory())
            AllNotesScreen(
                viewModel = vm,
                onAddNoteClick = {
                    navController.navigate(Screen.AddNote.route)
                },
                onNoteClick = { noteId ->
                    navController.navigate(Screen.EditNote.createRoute(noteId))
                }
            )
        }
        composable(route = Screen.AddNote.route) {
            var addNoteContainer by remember { mutableStateOf<Any?>(null) }
            DisposableEffect(Unit) {
                addNoteContainer = appContainer.getAddNoteContainer()
                onDispose {
                    appContainer.releaseAddNoteContainer()
                    addNoteContainer = null
                }
            }
            val vm: AddNoteViewModel = viewModel(factory = appContainer.getAddNoteContainer()?.getAddNoteViewModelFactory())
            AddNoteScreen(
                viewModel = vm,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Screen.EditNote.route,
            arguments = listOf(navArgument(NOTE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt(NOTE_ID) ?: 0
            var editNoteContainer by remember { mutableStateOf<Any?>(null) }
            DisposableEffect(Unit) {
                editNoteContainer = appContainer.getEditNoteContainer()
                onDispose {
                    appContainer.releaseEditNoteContainer()
                    editNoteContainer = null
                }
            }
            val vm: EditNoteViewModel = viewModel(factory = appContainer.getEditNoteContainer()?.getEditNoteViewModelFactory())
            EditNoteScreen(
                noteId = noteId,
                onBackClick = {
                    navController.popBackStack()
                },
                viewModel = vm
            )
        }
    }
}