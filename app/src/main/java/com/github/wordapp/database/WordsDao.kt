package com.github.wordapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.wordapp.model.Word

@Dao
interface WordsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(word: Word)

    @Query("SELECT * FROM words")
    fun getAllWords() : LiveData<List<Word>>
}