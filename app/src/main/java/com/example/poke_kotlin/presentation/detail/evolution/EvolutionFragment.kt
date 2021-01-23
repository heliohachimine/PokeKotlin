package com.example.poke_kotlin.presentation.detail.evolution

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_kotlin.R
import com.example.poke_kotlin.Utils
import kotlinx.android.synthetic.main.fragment_evolution.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class EvolutionFragment(val idChain: String, val type:String) : Fragment() {

    private val evolutionAdapter: EvolutionAdapter by inject()
    private val viewModel: EvolutionViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_evolution, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.getEvolutions(idChain)
        subscribeLiveData()
        tv_evolution_chart.setTextColor(resources.getColor(Utils.getColorByPokemonType(type)))

    }

    private fun setupRecyclerView() {
        rv_evolutions.adapter = evolutionAdapter
        rv_evolutions.layoutManager = LinearLayoutManager(context)
    }

    private fun subscribeLiveData() {
       viewModel.evolutionMutableLiveData.observe(viewLifecycleOwner, Observer {
           evolutionAdapter.setList(it)
       })
    }

}