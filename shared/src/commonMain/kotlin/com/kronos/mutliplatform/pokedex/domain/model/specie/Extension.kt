package com.kronos.pokedex.domian.model.specie

import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo
import kotlin.math.roundToInt

fun SpecieInfo.getHatchCounter():Int{
    return hatchCounter*255
}

fun SpecieInfo.getCaptureRate():Double{
    return (captureRate*0.13).roundToInt().toDouble()
}