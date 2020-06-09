package com.ferdows.pokedex.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonEvolution(
    val num: String,
    val name: String
)

@JsonClass(generateAdapter = true)
data class Pokemon(
    val id: Int,
    val num: String,
    val name: String,
    val img: String,
    val type: List<String>,
    val height: String,
    val weight: String,
    val candy: String,
    @Json(name = "candy_count") val candyCount: Int?,
    val egg: String,
    @Json(name = "spawn_chance") val spawnChance: Double,
    @Json(name = "avg_spawns") val averageSpawns: Double,
    @Json(name = "spawn_time") val spawnTime: String,
    val multipliers: List<Double>?,
    val weaknesses: List<String>,
    @Json(name = "prev_evolution") val prevEvolutions: List<PokemonEvolution>?,
    @Json(name = "next_evolution") val nextEvolutions: List<PokemonEvolution>?
)