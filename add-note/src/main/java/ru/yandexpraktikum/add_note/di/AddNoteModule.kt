package ru.yandexpraktikum.add_note.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractor
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractorImpl

@Module
@InstallIn(ViewModelComponent::class)
internal interface AddNoteModule {
    @Binds
    fun bindAddNoteInteractor(impl: AddNoteInteractorImpl): AddNoteInteractor
}