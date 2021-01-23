package com.example.poke_kotlin.presentation.detail.evolution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poke_kotlin.R

class EvolutionAdapter : RecyclerView.Adapter<EvolutionViewHolder>() {

    private var evolutions: List<EvolutionModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_evolution, parent, false)
        return EvolutionViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = this.evolutions.size

    override fun onBindViewHolder(holder: EvolutionViewHolder, position: Int) {
        holder.bind(evolutions[position])
    }

    fun setList(evolutions: List<EvolutionModel>) {
        this.evolutions = evolutions
        notifyDataSetChanged()
    }
}

class EvolutionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imagem_evolve_from: ImageView = itemView.findViewById(R.id.iv_pokemon_evolve_from)
    val number_evolve_from: TextView = itemView.findViewById(R.id.tv_pokemon_evolve_from_number)
    val name_evolve_from: TextView = itemView.findViewById(R.id.tv_pokemon_evolve_from_name)
    val imagem_evolve_to: ImageView = itemView.findViewById(R.id.iv_pokemon_evolve_to)
    val number_evolve_to: TextView = itemView.findViewById(R.id.tv_pokemon_evolve_to_number)
    val name_evolve_to: TextView = itemView.findViewById(R.id.tv_pokemon_evolve_to_name)
    val min_level: TextView = itemView.findViewById(R.id.tv_min_level)


    fun bind(evolution: EvolutionModel) {
        name_evolve_from.text = evolution.evolveFromName
        name_evolve_to.text = evolution.evolveToName
        min_level.text = "(Level ${evolution.minLevel})"

//        id.text = Utils.formatPokeNumber(pokemon.id)
//        name.text = pokemon.name
//        type1.setType(pokemon.types[0].type.name)
//        if (pokemon.types.size > 1) {
//            type2.visibility = View.VISIBLE
//            type2.setType(pokemon.types[1].type.name)
//        } else {
//            type2.visibility = View.INVISIBLE
//        }
//        setupBackground(pokemon.types[0].type.name)
//        Glide.with(itemView.context).load(pokemon.sprites.other.image.url)
//            .into(image)
    }

}
