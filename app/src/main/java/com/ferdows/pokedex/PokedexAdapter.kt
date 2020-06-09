package com.ferdows.pokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ferdows.pokedex.databinding.ItemPokemonBinding
import com.ferdows.pokedex.model.Pokemon
import com.ferdows.pokedex.view.PokemonItemViewHolder

class PokedexAdapter(
    val dataset: List<Pokemon>
) : RecyclerView.Adapter<PokemonItemViewHolder>() {

    override fun getItemCount() = dataset.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonItemViewHolder {
        val binding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonItemViewHolder, position: Int) {
        val pokemon = dataset[position]
        holder.bind(pokemon)
    }
}