package yurii.karpliuk.svitmovie.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yurii.karpliuk.svitmovie.dto.response.MovieResponse;
import yurii.karpliuk.svitmovie.entity.Movie;

public interface MovieService {
    Page<MovieResponse> findAllMovies(Pageable pageable);

    MovieResponse getOneById(Long id);

    MovieResponse buildMovieResponse(Movie movie);

    Page<MovieResponse> search(Pageable pageable,String categoryName);

    Page<MovieResponse> searchByTitleOfMovieLike(Pageable pageable,String movieTitle);
}
