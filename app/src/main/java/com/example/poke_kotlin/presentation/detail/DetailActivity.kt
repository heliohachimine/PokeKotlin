package com.example.poke_kotlin.presentation.detail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.poke_kotlin.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        if (intent.hasExtra("item_image")) {
            Glide.with(this).load(intent.getStringExtra("item_image"))
                .into(iv_pokemon)
        }
        if (intent.hasExtra("item_name")) {
            tv_name.text = intent.getStringExtra("item_name")
        }
        if (intent.hasExtra("item_type")) {
            setupType(intent.getStringExtra("item_type"))
        }


    }

    private fun setupType(type: String?) {
        when (type) {
            "bug" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeBug))
            "dark" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeDark))
            "dragon" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeDragon))
            "eletric" -> container.setBackgroundColor(this.getColor(R.color.backgroundTypeElectric))
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