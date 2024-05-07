package com.ataberk.thenotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ataberk.thenotesapp.database.NoteDatabase
import com.ataberk.thenotesapp.repository.NoteRepository
import com.ataberk.thenotesapp.viewmodel.NoteViewModel
import com.ataberk.thenotesapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {


    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }
    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application,noteRepository)
        noteViewModel=ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}