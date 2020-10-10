package com.example.poke_kotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_kotlin.R
import com.example.poke_kotlin.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: PokeLisViewModel by viewModel()
    private val pokeAdapter: PokeAdapter by inject()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()
        viewModel.getAllPokemon(offset = "0", limit = "20")
        setupRecyclerView()
        subscribeLiveData()
    }

    private fun setupRecyclerView() {
        binding.pokeList.adapter = pokeAdapter
        binding.pokeList.layoutManager = LinearLayoutManager(this)
    }

    private fun subscribeLiveData() {
        viewModel.pokemonsMutableLiveData.observe(this, Observer { list ->
            pokeAdapter.setList(list)
        })
    }
}