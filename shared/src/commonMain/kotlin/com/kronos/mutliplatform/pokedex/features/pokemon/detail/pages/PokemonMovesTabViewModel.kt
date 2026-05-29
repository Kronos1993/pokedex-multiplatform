package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PokemonMovesTabViewModel(
) : ParentViewModel() {

    private var _allMoves = MutableStateFlow(emptyList<MoveList>())

    private var _filteredMoves = MutableStateFlow(emptyList<MoveList>())
    var filteredMoves = _filteredMoves.asStateFlow()

    private var _selectedFilter = MutableStateFlow<String>("all")
    var selectedFilter = _selectedFilter.asStateFlow()

    private var _availableFilter = MutableStateFlow<List<Pair<String, String>>>(listOf())
    var availableFilter = _availableFilter.asStateFlow()

    var stringAllMoves = ""
    var stringEgg = ""
    var stringLevel = ""
    var stringTutor = ""
    var stringTM = ""
    var stringOther = ""

    fun initStrings(
        stringAllMoves: String = "",
        stringEgg: String = "",
        stringLevel: String = "",
        stringTutor: String = "",
        stringTM: String = "",
        stringOther: String = ""
    ) {
        this.stringAllMoves = stringAllMoves
        this.stringEgg = stringEgg
        this.stringLevel = stringLevel
        this.stringTutor = stringTutor
        this.stringTM = stringTM
        this.stringOther = stringOther
    }

    fun postMoves(moves: List<MoveList>) {
        _allMoves.value = moves
        _filteredMoves.value = moves
    }

    fun setFilter(method: String) {
        _selectedFilter.value = method
        _filteredMoves.value = if (method == "all") {
            _allMoves.value
        } else {
            _allMoves.value.filter {
                it.moveDetails.firstOrNull()?.moveLearnMethod == method
            }
        }
    }

    fun availableFilters() {
        _availableFilter.value = listOf(
            Pair("all", stringAllMoves),
            Pair("egg", stringEgg),
            Pair("level-up", stringLevel),
            Pair("tutor", stringTutor),
            Pair("machine", stringTM)
        )
    }
}
