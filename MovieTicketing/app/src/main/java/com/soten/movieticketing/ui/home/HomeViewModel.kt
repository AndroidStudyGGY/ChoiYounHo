package com.soten.movieticketing.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.soten.movieticketing.domain.models.Movie
import com.soten.movieticketing.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {

    private val _movies = MutableStateFlow<PagingData<Movie>>(PagingData.empty())
    val movies = _movies.asStateFlow()

    init {
        viewModelScope.launch {
            getMoviesUseCase()
                .cachedIn(viewModelScope)
                .collectLatest { pagingData ->
                    _movies.value = pagingData
                }
        }
    }

    fun getData() {
        viewModelScope.launch {
            getMoviesUseCase().collectLatest { pagingData ->
                _movies.value = pagingData
            }
        }
    }
}
