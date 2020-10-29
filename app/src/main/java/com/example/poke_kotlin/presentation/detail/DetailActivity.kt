package com.example.poke_kotlin.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.poke_kotlin.R
import com.example.poke_kotlin.Utils
import com.example.poke_kotlin.presentation.detail.about.AboutFragment
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var pokemonNumber: String

    private lateinit var aboutFragment: AboutFragment
    private val statsFragment = StatsFragment()
    private val evolutionFragment = EvolutionFragment()
    private val fragments = ArrayList<FragmentPage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()


        if (intent.hasExtra("item_number")) {
            pokemonNumber = intent.getStringExtra("item_number").toString()
            tv_number.text = Utils().formatPokeNumber(pokemonNumber)
        }

        if (intent.hasExtra("item_image")) {
            Glide.with(this).load(intent.getStringExtra("item_image"))
                .into(iv_pokemon)
        }

        viewModel.getPokemon(pokemonNumber)
        if (intent.hasExtra("item_type")) {
            val type = intent.getStringExtra("item_type")
            detail_tab_layout.setSelectedTabIndicatorColor(resources.getColor(Utils().getColorByPokemonType(type)))
            aboutFragment = AboutFragment(pokemonNumber, type.orEmpty())
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

            detail_type_slot_1.setType(pokemon.types[0].type.name)
            if (pokemon.types.size > 1) {
                detail_type_slot_2.visibility = View.VISIBLE
                detail_type_slot_2.setType(pokemon.types[1].type.name)
            } else {
                detail_type_slot_2.visibility = View.INVISIBLE
            }
        })
    }

    private fun setupType(type: String?) {
        container.setBackgroundResource(Utils().getColorByPokemonType(type))
    }
}