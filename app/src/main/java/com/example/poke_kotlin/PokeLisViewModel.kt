package com.example.poke_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke_kotlin.data.PokeRepository
import com.example.poke_kotlin.data.model.Pokemon
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PokeLisViewModel(private val repository: PokeRepository) : ViewModel() {

    val pokemonsMutableLiveData = MutableLiveData<List<Pokemon>>()

    fun getAllPokemon(offset: String, limit: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val pokemon = async { repository.getAllPokemons(offset, limit) }
                pokemonsMutableLiveData.postValue(pokemon.await().results.toList())
            }.onFailure {

            }
        }
    }
}