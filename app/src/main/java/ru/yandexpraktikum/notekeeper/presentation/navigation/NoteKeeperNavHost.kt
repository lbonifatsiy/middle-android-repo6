package ru.yandexpraktikum.notekeeper.presentation.navigation

import androidx.compose.runtime.Composable
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
            appContainer.initAllNotesContainer()
            val vm: AllNotesViewModel = viewModel(factory = appContainer.allNotesContainer?.getAllNotesViewModelFactory())
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
            appContainer.initAddNoteContainer()
            val vm: AddNoteViewModel = viewModel(factory = appContainer.addNoteContainer?.getAddNoteViewModelFactory())
            AddNoteScreen(
                viewModel = vm,
                onBackClick = {
                    navController.popBackStack()
                    appContainer.addNoteContainer = null
                }
            )
        }
        composable(
            route = Screen.EditNote.route,
            arguments = listOf(navArgument(NOTE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt(NOTE_ID) ?: 0
            appContainer.initEditNoteContainer()
            val vm: EditNoteViewModel = viewModel(factory = appContainer.editNoteContainer?.getEditNoteViewModelFactory())
            EditNoteScreen(
                noteId = noteId,
                onBackClick = {
                    navController.popBackStack()
                    appContainer.editNoteContainer = null
                },
                viewModel = vm
            )
        }
    }
}