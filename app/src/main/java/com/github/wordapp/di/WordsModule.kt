package com.github.wordapp.di

import com.github.wordapp.database.WordsDao
import com.github.wordapp.repository.WordsRepository
import com.github.wordapp.repository.WordsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class WordsModule {

    @Provides
    fun provideWordsRepository(wordsDao: WordsDao) : WordsRepository {
        return WordsRepositoryImpl(wordsDao)
    }
}