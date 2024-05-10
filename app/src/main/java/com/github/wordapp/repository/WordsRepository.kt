package com.github.wordapp.repository

import androidx.lifecycle.LiveData
import com.github.wordapp.model.Word

interface WordsRepository {
    fun insertWord(word: Word)

    fun getAllWords() : LiveData<List<Word>>
}