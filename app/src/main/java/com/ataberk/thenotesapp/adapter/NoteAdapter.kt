package com.ataberk.thenotesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ataberk.thenotesapp.databinding.NoteLayoutBinding
import com.ataberk.thenotesapp.fragments.HomeFragmentDirections
import com.ataberk.thenotesapp.fragments.HomeFragmentDirections.ActionHomeFragmentToEditNoteFragment
import com.ataberk.thenotesapp.fragments.HomeFragmentDirections.actionHomeFragmentToEditNoteFragment
import com.ataberk.thenotesapp.model.Note
import java.text.Bidi

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    class NoteViewHolder(val itemBinding: NoteLayoutBinding):RecyclerView.ViewHolder(itemBinding.root)
    private val differCallback = object :DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            TODO("Not yet implemented")
            return oldItem.id==newItem.id&&
                    oldItem.notedesc==newItem.notedesc&&
                    oldItem.noteTitle==newItem.noteTitle


        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            TODO("Not yet implemented")
            return oldItem==newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=differ.currentList[position]
        holder.itemBinding.noteTitle.text=currentNote.noteTitle
        holder.itemBinding.noteDesc.text=currentNote.notedesc
        holder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(currentNote)
            it.findNavController().navigate(direction)

        }

    }
}