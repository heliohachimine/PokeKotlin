package com.example.poke_kotlin.presentation.detail.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke_kotlin.data.PokeRepository
import com.example.poke_kotlin.data.model.Specie
import com.example.poke_kotlin.data.model.TypeDetail
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AboutViewModel(private val repository: PokeRepository) : ViewModel() {

    val typeMutableLiveData = MutableLiveData<TypeDetail>()
    val specieMutableLiveData = MutableLiveData<Specie>()

    fun getDataType(type: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val pokemon = async { repository.getType(type) }
                typeMutableLiveData.postValue(pokemon.await())
            }
        }
    }

    fun getDataSpecie(type: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val pokemon = async { repository.getSpecie(type) }
                specieMutableLiveData.postValue(pokemon.await())
            }
        }
    }

}