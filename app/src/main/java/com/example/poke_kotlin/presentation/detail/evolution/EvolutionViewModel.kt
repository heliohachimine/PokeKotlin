package com.example.poke_kotlin.presentation.detail.evolution

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke_kotlin.data.PokeRepository
import com.example.poke_kotlin.data.model.ChainEvolution
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class EvolutionViewModel(private val repository: PokeRepository) : ViewModel() {

    val evolutionMutableLiveData = MutableLiveData<List<EvolutionModel>>()

    fun getEvolutions(id: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val result = async { repository.getEvolutions(id) }
                val list = iterateData(result.await().chain)
                evolutionMutableLiveData.postValue(list)
            }
        }
    }

    private fun iterateData(evolution: ChainEvolution): ArrayList<EvolutionModel> {
        var iterator = evolution
        val list = ArrayList<EvolutionModel>()
        do {
            setData(evolution = iterator, list = list)
            iterator = iterator.evolveTo[0]
        } while (iterator.evolveTo.isNotEmpty())
        return list
    }

    private fun setData(evolution: ChainEvolution, list: ArrayList<EvolutionModel>) {
        val model = EvolutionModel(
            minLevel = evolution.evolveTo[0].evolutionDetails[0].minLevel,
            evolveFromName = evolution.species.name,
            evolveToName = evolution.evolveTo[0].species.name,
            evolveFromImage = "",
            evolveToImage = ""
        )
        list.add(model)
    }
}

data class EvolutionModel(
    val minLevel: String?,
    val evolveFromName: String,
    val evolveFromImage: String,
    val evolveToName: String,
    val evolveToImage: String
)