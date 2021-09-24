package com.example.poke_kotlin.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.poke_kotlin.R
import com.example.poke_kotlin.Utils
import com.example.poke_kotlin.data.model.TypeResult
import com.example.poke_kotlin.presentation.PokemonType
import com.example.poke_kotlin.presentation.detail.about.AboutFragment
import com.example.poke_kotlin.presentation.detail.evolution.EvolutionFragment
import com.example.poke_kotlin.presentation.detail.stats.StatsFragment
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var pokemonNumber: String

    private lateinit var aboutFragment: AboutFragment
    private val statsFragment = StatsFragment()
    private lateinit var evolutionFragment: EvolutionFragment
    private val fragments = ArrayList<FragmentPage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()

        if (intent.hasExtra("item_number")) {
            pokemonNumber = intent.getStringExtra("item_number").toString()
            tv_number.text = Utils.formatPokeNumber(pokemonNumber)
        }

        if (intent.hasExtra("item_image")) {
            Glide.with(this).load(intent.getStringExtra("item_image"))
                .into(iv_pokemon)
        }

        viewModel.getPokemon(pokemonNumber)
        if (intent.hasExtra("item_type")) {
            val type = intent.getStringExtra("item_type")
            detail_tab_layout.setSelectedTabIndicatorColor(resources.getColor(Utils.getColorByPokemonType(type)))
            aboutFragment = AboutFragment(id = pokemonNumber, type = type.orEmpty())
            //TODO é necessario passar o id chain nao o id do pokemon
            evolutionFragment = EvolutionFragment(idChain = pokemonNumber, type = type.orEmpty())
            setupType(type)

        }
        setupViewPager()
        subscribeLiveData()
    }

    private fun setupViewPager() {
        //TODO remover os titulos hard coded
        fragments.add(FragmentPage(title = "About", fragment = aboutFragment))
        fragments.add(FragmentPage(title = "Stats", fragment = statsFragment))
        fragments.add(FragmentPage(title = "Evolution", fragment = evolutionFragment))
        pager.adapter = DetailPageAdapter(supportFragmentManager, fragments)
    }

    private fun subscribeLiveData() {
        viewModel.pokemonMutableLiveData.observe(this, Observer {   pokemon ->
            tv_name.text = pokemon.name
            aboutFragment.setData(pokemon)
            val firstType = pokemon.types?.get(0) as TypeResult
            val firstPokemonType = PokemonType.valueOf(firstType.type.name.toUpperCase(Locale.ROOT))

            detail_type_slot_1.setType(firstPokemonType)
            if ((pokemon.types.size) > 1 ) {
                detail_type_slot_2.visibility = View.VISIBLE

                val secondType = pokemon.types[1]
                val secondPokemonType = PokemonType.valueOf(secondType.type.name.toUpperCase(Locale.ROOT))
                detail_type_slot_2.setType(secondPokemonType)
            } else {
                detail_type_slot_2.visibility = View.INVISIBLE
            }
        })
    }

    private fun setupType(type: String?) {
        container.setBackgroundResource(Utils.getColorByPokemonType(type))
    }
}