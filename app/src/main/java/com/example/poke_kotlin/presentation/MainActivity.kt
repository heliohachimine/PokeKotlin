package com.example.poke_kotlin.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_kotlin.R
import com.example.poke_kotlin.presentation.list.PaginationScrollListener
import com.example.poke_kotlin.presentation.list.PokeAdapter
import com.example.poke_kotlin.presentation.list.PokeListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.SimpleItemAnimator




class MainActivity : AppCompatActivity() {

    private val viewModel: PokeListViewModel by viewModel()
    private val pokeAdapter: PokeAdapter by inject()
    private var page = 0
    private var isLastPage = false
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        getItems()
        setupRecyclerView()
        setRecyclerViewScrollListener()
        subscribeLiveData()
    }

    private fun setupRecyclerView() {
        pokeAdapter.setHasStableIds(true)
        poke_list.adapter = pokeAdapter
        poke_list.layoutManager = LinearLayoutManager(this)
    }

    private fun getItems() {
        viewModel.getAllPokemon((page*20).toString())
    }

    private fun setRecyclerViewScrollListener() {
        poke_list.addOnScrollListener(object : PaginationScrollListener(poke_list.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }
            override fun isLoading(): Boolean {
                return isLoading
            }
            override fun loadMoreItems() {
                progress_circular.visibility = View.VISIBLE
                isLoading = true
                page+=1
                getItems()
            }
        })
    }

    private fun subscribeLiveData() {
        viewModel.pokemonsMutableLiveData.observe(this, Observer { list ->
            progress_circular.visibility = View.GONE
            pokeAdapter.addItems(list)
            isLoading = false
        })
    }
}