package com.prueba.tecniva.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prueba.tecniva.data.entities.movies.MoviesResponse
import com.prueba.tecniva.data.entities.movies.Results
import com.prueba.tecniva.data.network.base.onResult
import com.prueba.tecniva.domain.usecases.GetMoviesUseCase
import com.prueba.tecniva.ui.base.BaseViewModel
import com.prueba.tecniva.ui.base.Event
import com.prueba.tecniva.util.constants.emptyString
import com.prueba.tecniva.util.extensions.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) :BaseViewModel() {

    private var page = 1
    var canRefresh= true
    private val _movies = MutableLiveData<Event<MoviesResponse>>()
    val movies: LiveData<Event<MoviesResponse>> = _movies
    private val _movie = MutableLiveData<Results>()
    val movie: LiveData<Results> = _movie
    val movieName = MutableLiveData(emptyString())
    private val _errorLoadingItems = MutableLiveData<Event<Boolean>>()
    val errorLoadingItems: LiveData<Event<Boolean>> = _errorLoadingItems
    private val _errorNotFound = MutableLiveData<Event<Boolean>>()
    val errorNotFound: LiveData<Event<Boolean>> = _errorNotFound
    private val _showLoadingDialog = MutableLiveData(false)
    val showLoadingDialog: LiveData<Boolean> = _showLoadingDialog

    fun getMovies() {
        if (_movies.value?.peekContent()?.results.isNullOrEmpty() || movieName.value.isNullOrEmpty()) {
            showLoading()
            loadingBlock {
                getMoviesUseCase.execute(page).onResult(
                    {_movies.postValue(Event(it))},
                    {_errorLoadingItems.sendEvent()}
                )
            }
            hideLoading()
        } else {
            _movies.postValue(Event(movies.value!!.peekContent()))
        }
    }

    fun findMovieByTitle() {
        if (movieName.value.isNullOrEmpty()) {
            page = 1
            getMovies()
            canRefresh = true
        } else {
            showLoading()
            canRefresh = false
            val list: MutableList<Results> = mutableListOf()
            _movies.value!!.peekContent().results.forEach {
                if (it.originalTitle!!.lowercase().startsWith(movieName.value!!.toLowerCase(Locale.ROOT))) {
                    list.add(it)
                }
            }

            if (list.isEmpty()) {
                if (page < 100) {
                    addMovies(false)
                } else {
                    _errorNotFound.sendEvent()
                    hideLoading()
                }

            } else {
                _movies.postValue(
                    Event(
                        MoviesResponse(
                            results = list
                        )
                    )
                )
                hideLoading()
            }

        }
    }

    fun recoverSearch() {
        if (movieName.value.isNullOrEmpty()) {
            findMovieByTitle()
        }
    }

    fun addMovies(isRefresh: Boolean = true) {
        page++
        showLoading()
        loadingBlock {
            getMoviesUseCase.execute(page).onResult(
                { moviesResponse ->
                    val list: MutableList<Results> = mutableListOf()
                    _movies.value!!.peekContent().results.forEach {
                        list.add(it)
                    }
                    moviesResponse.results.forEach {
                        list.add(it)
                    }
                    _movies.postValue(
                        Event(
                            MoviesResponse(
                                results = list
                            )
                        )
                    )
                    if (!isRefresh) {
                        findMovieByTitle()
                    } else {
                        hideLoading()
                    }
                },
                {_errorLoadingItems.sendEvent()}
            )
        }
    }

    fun setMovie(movie: Results) {
        _movie.postValue(movie)
    }

    private fun showLoading() {
        _showLoadingDialog.postValue(true)
    }

    private fun hideLoading() {
        _showLoadingDialog.postValue(false)
    }

}