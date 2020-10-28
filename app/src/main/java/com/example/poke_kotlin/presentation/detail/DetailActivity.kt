package com.example.poke_kotlin.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.poke_kotlin.R
import com.example.poke_kotlin.Utils
import com.example.poke_kotlin.data.model.Pokemon
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var pokemonNumber: String
    private lateinit var pokemon: Pokemon

    private val fragments = ArrayList<FragmentPage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        setupViewPager()

        if (intent.hasExtra("item_number")) {
            pokemonNumber = intent.getStringExtra("item_number").toString()
            tv_number.text = Utils().formatPokeNumber(pokemonNumber)
        }
        if (intent.hasExtra("item_image")) {
            Glide.with(this).load(intent.getStringExtra("item_image"))
                .into(iv_pokemon)
        }
        if (intent.hasExtra("item_name")) {
            tv_name.text = intent.getStringExtra("item_name")
        }
        viewModel.getPokemon(pokemonNumber)
        if (intent.hasExtra("item_type")) {
            setupType(intent.getStringExtra("item_type"))
        }
        subscribeLiveData()
    }

    private fun setupViewPager() {
        fragments.add(FragmentPage(title = "About", fragment = AboutFragment()))
        fragments.add(FragmentPage(title = "Stats", fragment = StatsFragment()))
        fragments.add(FragmentPage(title = "Evolution", fragment = EvolutionFragment()))
        pager.adapter = DetailPageAdapter(supportFragmentManager, fragments)
    }

    private fun subscribeLiveData() {
        viewModel.pokemonMutableLiveData.observe(this, Observer {   pokemon ->
            tv_name.text = pokemon.name
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
        when (type) {
            "bug" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeBug))
            "dark" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeDark))
            "dragon" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeDragon))
            "electric" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeElectric))
            "fairy" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeFairy))
            "fighting" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeFighting))
            "fire" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeFire))
            "flying" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeFlying))
            "ghost" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeGhost))
            "grass" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeGrass))
            "ground" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeGround))
            "ice" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeIce))
            "normal" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeNormal))
            "poison" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypePoison))
            "psychic" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypePsychic))
            "rock" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeRock))
            "steel" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeSteel))
            "water" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeWater))
        }
    }
}