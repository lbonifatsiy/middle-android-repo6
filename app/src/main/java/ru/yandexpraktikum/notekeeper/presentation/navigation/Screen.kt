package ru.yandexpraktikum.notekeeper.presentation.navigation

sealed class Screen(val route: String) {
    data object AllNotes : Screen("all_notes")
    data object AddNote : Screen("add_note")
    data object EditNote : Screen("edit_note/{noteId}") {
        fun createRoute(noteId: Int) = "edit_note/$noteId"
    }
}