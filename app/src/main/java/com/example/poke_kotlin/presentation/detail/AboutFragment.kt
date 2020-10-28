package com.example.poke_kotlin.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poke_kotlin.R
import com.example.poke_kotlin.data.model.Pokemon
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    //TODO passar somente os dados necessarios para otimizar o fluxo de dados
    fun setData(pokemon: Pokemon) {
        tv_width.text = pokemon.weight
        tv_height.text = pokemon.height
    }
}