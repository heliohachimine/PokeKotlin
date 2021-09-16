package com.example.poke_kotlin.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke_kotlin.data.PokeRepository
import com.example.poke_kotlin.data.model.Pokemon
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PokeListViewModel(private val repository: PokeRepository) : ViewModel() {

    val pokemonsMutableLiveData = MutableLiveData<List<Pokemon>>()

    fun getAllPokemon(page: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val pokemon = async { repository.getAllPokemons(page = page) }
                val pokeList = ArrayList<Pokemon>()
//                pokemonsMutableLiveData.value?.toList()?.let { pokeList.addAll(it) }
                pokemon.await().results.toList().forEach {
                    val pokemonDetailed = async { it.name?.let { it1 ->
                        repository.getSinglePokemon(
                            it1
                        )
                    } }
                    pokemonDetailed.await()?.let { it1 -> pokeList.add(it1) }
                }
                pokemonsMutableLiveData.postValue(pokeList)
            }.onFailure {

            }
        }
    }
}