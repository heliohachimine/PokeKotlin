package com.example.poke_kotlin.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke_kotlin.data.PokeRepository
import com.example.poke_kotlin.data.model.Pokemon
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: PokeRepository) : ViewModel() {

    val pokemonMutableLiveData = MutableLiveData<Pokemon>()

    fun getPokemon(id: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val pokemon = async { repository.getSinglePokemon(query = id) }
                pokemonMutableLiveData.postValue(pokemon.await())
            }
        }
    }
}