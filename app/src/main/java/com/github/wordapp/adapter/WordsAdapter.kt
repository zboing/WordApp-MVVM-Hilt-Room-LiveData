package com.github.wordapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.wordapp.databinding.ItemWordBinding
import com.github.wordapp.model.Word
import com.github.wordapp.viewmodel.WordsViewModel
import javax.inject.Inject

interface Interaction

class WordsAdapter @Inject constructor(private val viewModel: WordsViewModel, private val interaction: Interaction? = null) :
    ListAdapter<Word, WordsAdapter.WordViewHolder>(ComparatorDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WordViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Word) {
            binding.word = item

            binding.delete.setOnClickListener{
                viewModel.deleteWord(item)
            }
        }
    }


    class ComparatorDiffUtil : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }
    }
}