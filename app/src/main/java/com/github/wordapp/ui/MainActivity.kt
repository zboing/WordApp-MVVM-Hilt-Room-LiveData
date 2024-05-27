package com.github.wordapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.github.wordapp.adapter.WordsAdapter
import com.github.wordapp.databinding.ActivityMainBinding
import com.github.wordapp.viewmodel.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : WordsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wordsAdapter = WordsAdapter(viewModel = viewModel)

        binding.rv.apply {
            adapter = wordsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.getAllWords().observe(this) {
            wordsAdapter.submitList(it)
        }

        binding.fab.setOnClickListener { showAddWordDialog() }
    }

    @SuppressLint("CheckResult")
    private fun showAddWordDialog(){
        MaterialDialog(this).show {
            input { dialog, text ->
                viewModel.saveWord(text.toString())
            }
            positiveButton(text = "Submit")
        }
    }

}