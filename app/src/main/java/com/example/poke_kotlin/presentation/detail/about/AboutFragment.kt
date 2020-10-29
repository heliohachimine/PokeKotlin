package com.example.poke_kotlin.presentation.detail.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.poke_kotlin.R
import com.example.poke_kotlin.Utils
import com.example.poke_kotlin.data.model.Pokemon
import kotlinx.android.synthetic.main.fragment_about.*
import org.koin.android.viewmodel.ext.android.viewModel

class AboutFragment(val id: String, val type: String) : Fragment() {

    private val viewModel: AboutViewModel by viewModel()
    private var weight = ""
    private var height = ""
    private var baseExperience = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_pokedex_data.setTextColor(resources.getColor(Utils().getColorByPokemonType(type)))
        tv_training.setTextColor(resources.getColor(Utils().getColorByPokemonType(type)))

        setFields()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getDataType(type)
        viewModel.getDataSpecie(id)
        subscribeLiveData()

    }

    //TODO passar somente os dados necessarios para otimizar o fluxo de dados
    fun setData(pokemon: Pokemon) {
        weight = Utils().formatWeight(pokemon.weight)
        height = Utils().formatHeight(pokemon.height)
        baseExperience = pokemon.baseExperience
        setFields()
    }

    private fun setFields() {
        tv_weight.text = weight
        tv_height.text = height
        tv_base_experience.text = baseExperience
    }

    private fun subscribeLiveData() {
        viewModel.typeMutableLiveData.observe(viewLifecycleOwner, Observer { it ->
            var weak = ""
            it.relations.doubleDamageFrom?.forEach { type ->
                weak = weak + " " + type.name
            }
            tv_weaknesses.text = weak
        })

        viewModel.specieMutableLiveData.observe(viewLifecycleOwner, Observer {
            tv_base_happiness.text = it.baseHappiness
            tv_capture_rate.text = it.captureRate
            tv_growth_rate.text = it.growthRate.name
        })
    }
}