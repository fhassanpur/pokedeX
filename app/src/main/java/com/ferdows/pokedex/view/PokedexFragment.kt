package com.ferdows.pokedex.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferdows.pokedex.PokedexAdapter
import com.ferdows.pokedex.R
import com.ferdows.pokedex.databinding.FragmentPokedexBinding
import com.ferdows.pokedex.model.Pokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class PokedexFragment : Fragment() {

    private var _binding: FragmentPokedexBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        binding.pokedexFragmentRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = PokedexAdapter(parsePokedex())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parsePokedex(): List<Pokemon> {
        val pokedexJsonStr = resources.openRawResource(R.raw.pokedex)
            .bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder().build()
        val listPokemon = Types.newParameterizedType(List::class.java, Pokemon::class.java)
        val pokemonAdapter = moshi.adapter<List<Pokemon>>(listPokemon)
        val pokemon = pokemonAdapter.fromJson(pokedexJsonStr)
        return pokemon ?: emptyList()
    }

}