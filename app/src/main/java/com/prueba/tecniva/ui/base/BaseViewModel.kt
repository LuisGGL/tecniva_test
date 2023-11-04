package com.prueba.tecniva.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prueba.tecniva.util.extensions.launch
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

abstract class BaseViewModel: ViewModel() {

    private fun loadingBlocks(vararg block: suspend () -> Unit) {
        launch {
            block.map {
                async { it() }
            }.awaitAll()
        }
    }

    protected fun loadingBlock(block: suspend () -> Unit) {
        loadingBlocks({ block() })
    }
}