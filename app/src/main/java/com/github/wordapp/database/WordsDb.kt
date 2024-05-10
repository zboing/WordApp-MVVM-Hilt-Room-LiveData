package com.github.wordapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.wordapp.model.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordsDb : RoomDatabase() {

    abstract fun wordsDao() : WordsDao
}