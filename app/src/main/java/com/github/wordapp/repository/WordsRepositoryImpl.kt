package com.github.wordapp.repository

import androidx.lifecycle.LiveData
import com.github.wordapp.database.WordsDao
import com.github.wordapp.model.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class WordsRepositoryImpl (private val wordsDao : WordsDao): WordsRepository {
    override fun insertWord(word: Word) {
        CoroutineScope(IO).launch {
            wordsDao.insertWord(word)
        }
    }

    override fun deleteWord(word: Word) {
        CoroutineScope(IO).launch {
            wordsDao.deleteWord(word)
        }
    }

    override fun getAllWords(): LiveData<List<Word>> {
        return wordsDao.getAllWords()
    }
}