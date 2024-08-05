package com.soten.movieticketing.domain.usecase

import com.soten.movieticketing.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {

    operator fun invoke() = movieRepository.getMovies()

}