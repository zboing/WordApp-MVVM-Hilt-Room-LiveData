package com.github.wordapp.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideWordsDb(@ApplicationContext context: Context) : WordsDb {
        return Room.databaseBuilder(context, WordsDb::class.java, "wordsdb").build()
    }

    @Provides
    fun provideWordsDao(wordsDb: WordsDb) : WordsDao {
        return wordsDb.wordsDao()
    }
}