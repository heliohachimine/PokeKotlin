package com.example.poke_kotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_kotlin.R
import com.example.poke_kotlin.databinding.ActivityMainBinding
import com.example.poke_kotlin.presentation.list.PaginationScrollListener
import com.example.poke_kotlin.presentation.list.PokeAdapter
import com.example.poke_kotlin.presentation.list.PokeListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: PokeListViewModel by viewModel()
    private val pokeAdapter: PokeAdapter by inject()
    private lateinit var binding: ActivityMainBinding
    private var page = 0
    private var isLastPage = false
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()
        viewModel.getAllPokemon((page*20).toString())
        setupRecyclerView()
        setRecyclerViewScrollListener()
        subscribeLiveData()
    }

    private fun setupRecyclerView() {
        binding.pokeList.adapter = pokeAdapter
        binding.pokeList.layoutManager = LinearLayoutManager(this)
    }

    private fun getMoreItems() {
        viewModel.getAllPokemon((page*20).toString())
    }

    private fun setRecyclerViewScrollListener() {
        poke_list.addOnScrollListener(object : PaginationScrollListener(binding.pokeList.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }
            override fun isLoading(): Boolean {
                return isLoading
            }
            override fun loadMoreItems() {
                isLoading = true
                page+=1
                getMoreItems()
            }
        })
    }

    private fun subscribeLiveData() {
        viewModel.pokemonsMutableLiveData.observe(this, Observer { list ->
            pokeAdapter.setList(list)
            isLoading = false
        })
    }
}