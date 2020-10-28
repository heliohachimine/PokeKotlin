package com.example.poke_kotlin.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.poke_kotlin.R
import kotlinx.android.synthetic.main.layout_type.view.*

class TypeComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private lateinit var type: String
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.layout_type, this, true)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it,
                R.styleable.type_component_attributes, 0, 0)
            val title = resources.getText(typedArray
                .getResourceId(R.styleable
                    .type_component_attributes_type,
                    R.string.default_type))
            text_type.text = title
            type = title as String
            typedArray.recycle()
        }
        setIcon(this.type)
    }

    fun setType(type: String) {
        this.type = type
        setIcon(this.type)
        text_type.text = type
    }

    //TODO implementar um ENUM para type isso evitará bugs por escrita errada
    private fun setIcon(type: String) {
        when(type) {
            "bug" -> {
                ic_type.setBackgroundResource(R.drawable.ic_bug)
                container_type.setBackgroundResource(R.drawable.background_type_bug)
            }
            "dark" -> {
                ic_type.setBackgroundResource(R.drawable.ic_dark)
                container_type.setBackgroundResource(R.drawable.background_type_dark)
            }
            "dragon" -> {
                ic_type.setBackgroundResource(R.drawable.ic_dragon)
                container_type.setBackgroundResource(R.drawable.background_type_dragon)
            }
            "electric" -> {
                ic_type.setBackgroundResource(R.drawable.ic_electric)
                container_type.setBackgroundResource(R.drawable.background_type_electric)
            }
            "fairy" -> {
                ic_type.setBackgroundResource(R.drawable.ic_fairy)
                container_type.setBackgroundResource(R.drawable.background_type_fairy)
            }
            "fighting" -> {
                ic_type.setBackgroundResource(R.drawable.ic_fighting)
                container_type.setBackgroundResource(R.drawable.background_type_fighting)
            }
            "fire" -> {
                ic_type.setBackgroundResource(R.drawable.ic_fire)
                container_type.setBackgroundResource(R.drawable.background_type_fire)
            }
            "flying" -> {
                ic_type.setBackgroundResource(R.drawable.ic_flying)
                container_type.setBackgroundResource(R.drawable.background_type_flying)
            }
            "ghost" -> {
                ic_type.setBackgroundResource(R.drawable.ic_ghost)
                container_type.setBackgroundResource(R.drawable.background_type_ghost)
            }
            "grass" -> {
                ic_type.setBackgroundResource(R.drawable.ic_grass)
                container_type.setBackgroundResource(R.drawable.background_type_grass)
            }
            "ground" -> {
                ic_type.setBackgroundResource(R.drawable.ic_ground)
                container_type.setBackgroundResource(R.drawable.background_type_ground)
            }
            "ice" -> {
                ic_type.setBackgroundResource(R.drawable.ic_ice)
                container_type.setBackgroundResource(R.drawable.background_type_ice)
            }
            "normal" -> {
                ic_type.setBackgroundResource(R.drawable.ic_normal)
                container_type.setBackgroundResource(R.drawable.background_type_normal)
            }
            "poison" -> {
                ic_type.setBackgroundResource(R.drawable.ic_poison)
                container_type.setBackgroundResource(R.drawable.background_type_poison)
            }
            "psychic" -> {
                ic_type.setBackgroundResource(R.drawable.ic_psychic)
                container_type.setBackgroundResource(R.drawable.background_type_psychic)
            }
            "rock" -> {
                ic_type.setBackgroundResource(R.drawable.ic_rock)
                container_type.setBackgroundResource(R.drawable.background_type_rock)
            }
            "steel" -> {
                ic_type.setBackgroundResource(R.drawable.ic_steel)
                container_type.setBackgroundResource(R.drawable.background_type_steel)
            }
            "water" -> {
                ic_type.setBackgroundResource(R.drawable.ic_water)
                container_type.setBackgroundResource(R.drawable.background_type_water)
            }
        }
    }
}