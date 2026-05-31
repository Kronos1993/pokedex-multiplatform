package com.kronos.mutliplatform.pokedex

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.util.ICloseApp
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    private var closeApp: ICloseApp,
    val platform: Platform,
) : ParentViewModel() {

    private var _showExitDialog = MutableStateFlow(false)
    var showExitDialog: StateFlow<Boolean> = _showExitDialog.asStateFlow()


    fun showExitDialog(show: Boolean) {
        _showExitDialog.value = show
    }

    fun closeApp() {
        viewModelScope.launch(Dispatchers.IO) {
            closeApp.closeApp()
        }
    }
}

