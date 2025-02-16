package ru.yandexpraktikum.notekeeper.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.yandexpraktikum.notekeeper.presentation.addnote.AddNoteScreen
import ru.yandexpraktikum.notekeeper.presentation.allnotes.AllNotesScreen
import ru.yandexpraktikum.notekeeper.presentation.editnote.EditNoteScreen

private const val NOTE_ID = "noteId"

@Composable
fun NoteKeeperNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AllNotes.route
    ) {
        composable(route = Screen.AllNotes.route) {
            AllNotesScreen(onAddNoteClick = {
                navController.navigate(Screen.AddNote.route)
            },
                onNoteClick = { noteId ->
                    navController.navigate(Screen.EditNote.createRoute(noteId))
                })
        }
        composable(route = Screen.AddNote.route) {
            AddNoteScreen(onBackClick = {
                navController.popBackStack()
            })
        }
        composable(
            route = Screen.EditNote.route,
            arguments = listOf(navArgument(NOTE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt(NOTE_ID) ?: 0
            EditNoteScreen(
                noteId = noteId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}