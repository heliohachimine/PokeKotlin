package com.example.poke_kotlin.presentation

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
                val pokeList = ArrayList<Pokemon>()
                pokemon.await().results.toList().forEach {
                    val pokemonDetailed = async { repository.getSinglePokemon(it.name) }
                    pokeList.add(pokemonDetailed.await())
                }
                pokemonsMutableLiveData.postValue(pokeList)
            }.onFailure {

            }
        }
    }
}