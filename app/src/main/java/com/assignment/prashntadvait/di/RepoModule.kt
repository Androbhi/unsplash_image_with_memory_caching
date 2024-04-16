package com.assignment.prashntadvait.di

import com.assignment.prashntadvait.repo.ImageListRepo
import com.assignment.prashntadvait.repo.ImageListRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindsImageListRepo(
        imageRepoImpl: ImageListRepoImpl
    ): ImageListRepo

}