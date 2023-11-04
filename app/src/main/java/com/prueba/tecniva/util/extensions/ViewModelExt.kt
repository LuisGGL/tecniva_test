package com.prueba.tecniva.util.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.tecniva.ui.base.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun ViewModel.launch(block: suspend CoroutineScope.() -> Unit) =
    viewModelScope.launch(block = block)

fun MutableLiveData<Event<Boolean>>.sendEvent(value: Boolean = true) {
    postValue(Event(value))
}