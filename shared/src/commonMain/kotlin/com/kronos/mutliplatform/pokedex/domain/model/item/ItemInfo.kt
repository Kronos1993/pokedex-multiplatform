package com.kronos.mutliplatform.pokedex.domain.model.item

import com.kronos.mutliplatform.pokedex.domain.model.EffectEntry
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.sprite.Sprite
import kotlinx.serialization.Serializable

@Serializable
data class ItemInfo(
    var attributes:List<NamedResourceApi> = listOf(),
    var babyTriggerFor: ResourceApi = ResourceApi(),
    var category: NamedResourceApi = NamedResourceApi(),
    var cost:Int = 0,
    var effectEntries:List<EffectEntry> = listOf(),
    var descriptions:List<FlavorText> = listOf(),
    var flingEffect: NamedResourceApi = NamedResourceApi(),
    var flingPower:Int = 0,
    var heldByPokemon:List<NamedResourceApi> = listOf(),
    var id:Int = 0,
    var name:String = "",
    var names:List<Name> = listOf(),
    var sprites:Sprite = Sprite()
){
    fun getName(language: String): String {
        return names
            .firstOrNull { it.language.name == language }
            ?.name
            ?: names.firstOrNull { it.language.name == "en" }?.name
            ?: names.firstOrNull()?.name
            ?: name
    }
}
