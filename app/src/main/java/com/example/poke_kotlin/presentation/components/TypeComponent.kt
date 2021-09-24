package com.example.poke_kotlin.presentation.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.poke_kotlin.R
import com.example.poke_kotlin.presentation.PokemonType
import kotlinx.android.synthetic.main.layout_type.view.*
import java.util.*

class TypeComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private lateinit var type: PokemonType
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.layout_type, this, true)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it,
                R.styleable.type_component_attributes, 0, 0)
            val title = resources.getText(typedArray
                .getResourceId(
                    R.styleable.type_component_attributes_type,
                    R.string.default_type
                )
            )
            text_type.text = title
            type = PokemonType.valueOf(title.toString().toUpperCase(Locale.ROOT))
            typedArray.recycle()
        }
        setIcon(this.type)
    }

    fun setType(type: PokemonType) {
        this.type = type
        setIcon(this.type)
        text_type.text = type.name.toLowerCase(Locale.ROOT)
    }

    private fun setIcon(type: PokemonType) {
        ic_type.setBackgroundResource(type.icon)
        container_type.setBackgroundResource(type.backgroundCard)
    }
}