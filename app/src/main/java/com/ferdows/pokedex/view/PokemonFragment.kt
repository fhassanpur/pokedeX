package com.ferdows.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ferdows.pokedex.databinding.FragmentPokedexBinding
import com.ferdows.pokedex.databinding.FragmentPokemonBinding
import com.ferdows.pokedex.model.ElementTypeUtil
import com.ferdows.pokedex.model.Pokemon

class PokemonFragment : Fragment() {

    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!
    private val args: PokemonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)

        val pokemon = args.pokemon
        bind(pokemon)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bind(pokemon: Pokemon) {
        binding.pokemonNameTextView.text = pokemon.name
        binding.pokemonNumberTextView.text = pokemon.num
        Glide.with(binding.root)
            .load(pokemon.img)
            .fitCenter()
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.pokemonImageView)

        val mainType = pokemon.type.first()
        val mainColorRes = ElementTypeUtil.elementTypeFromString(mainType).colorResource
        val mainColor = requireContext().getColor(mainColorRes)
        binding.pokemonType1TextView.text = mainType
        binding.pokemonType1TextView.background.setTint(mainColor)

        if (pokemon.type.size == 2) {
            val secondType = pokemon.type[1]
            val secondColorRes = ElementTypeUtil.elementTypeFromString(secondType).colorResource
            val secondColor = requireContext().getColor(secondColorRes)
            binding.pokemonType2TextView.text = secondType
            binding.pokemonType2TextView.background.setTint(secondColor)
        } else {
            binding.pokemonType2TextView.visibility = View.GONE
        }
    }


}