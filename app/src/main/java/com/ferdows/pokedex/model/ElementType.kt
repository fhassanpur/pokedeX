package com.ferdows.pokedex.model

import com.ferdows.pokedex.R
import java.util.*

enum class ElementType(val colorResource: Int) {
    NORMAL(R.color.type_normal),
    FIGHTING(R.color.type_fighting),
    FLYING(R.color.type_flying),
    POISON(R.color.type_poison),
    GROUND(R.color.type_ground),
    ROCK(R.color.type_rock),
    BUG(R.color.type_bug),
    GHOST(R.color.type_ghost),
    FIRE(R.color.type_fire),
    WATER(R.color.type_water),
    GRASS(R.color.type_grass),
    ELECTRIC(R.color.type_electric),
    PSYCHIC(R.color.type_psychic),
    ICE(R.color.type_ice),
    DRAGON(R.color.type_dragon),
    UNKNOWN(R.color.white)
}

object ElementTypeUtil {

    fun elementTypeFromString(input: String): ElementType {
        val elementTypes = ElementType.values()
        for (type in elementTypes) {
            if (type.name.toLowerCase(Locale.ROOT) == input.toLowerCase(Locale.ROOT)) {
                return type
            }
        }

        return ElementType.UNKNOWN
    }

}