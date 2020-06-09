package com.ferdows.pokedex.view

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ferdows.pokedex.databinding.ItemPokemonBinding
import com.ferdows.pokedex.model.Pokemon

class PokemonItemViewHolder(
    private var binding: ItemPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon) {
        binding.itemPokemonId.text = pokemon.id.toString()
        binding.itemPokemonName.text = pokemon.name
        Glide.with(binding.root)
            .load(pokemon.img)
            .fitCenter()
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.itemPokemonImg)
    }

}