package com.github.wordapp.viewmodel

import androidx.lifecycle.ViewModel
import com.github.wordapp.repository.WordsRepository
import com.github.wordapp.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor (private val wordsRepository : WordsRepository) : ViewModel() {

    fun saveWord(text: String) = wordsRepository.insertWord(Word(0, text))

    fun getAllWords() = wordsRepository.getAllWords()
}