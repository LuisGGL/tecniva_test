package com.prueba.tecniva.ui.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    protected abstract val viewModel: T

    inline fun <reified VM : ViewModel> factory() = viewModels<VM>()

    inline fun <reified VM : ViewModel> factory(navId: Int) = hiltNavGraphViewModels<VM>(navId)


    fun <T> LiveData<Event<T>>.observeEvent(cb: (T) -> Unit) {
        observe(viewLifecycleOwner, EventObserver(cb))
    }

    fun <T> LiveData<T>.observe(cb: (T?) -> Unit) {
        observe(viewLifecycleOwner, cb)
    }

    fun <DB : ViewDataBinding> DB.bindLayout(bind: DB.() -> Unit) = bind(this).let {
        lifecycleOwner = viewLifecycleOwner
        root
    }

}