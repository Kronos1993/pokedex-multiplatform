package com.kronos.mutliplatform.pokedex.features.about

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.util.IExpectedIntents
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import kotlinx.coroutines.launch

class AboutViewModel(
    val intents: IExpectedIntents,
    private val appInfo: IAppInfo
) : ParentViewModel() {

    fun openBrowser(url: String) {
        viewModelScope.launch {
            intents.openBrowser(url)
        }
    }

    var appVersion = appInfo.getAppVersion()

}