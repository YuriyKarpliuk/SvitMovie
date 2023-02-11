package yurii.karpliuk.svitmovie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import yurii.karpliuk.svitmovie.dto.response.MovieResponse;
import yurii.karpliuk.svitmovie.entity.Category;
import yurii.karpliuk.svitmovie.entity.Movie;
import yurii.karpliuk.svitmovie.repository.MovieRepository;
import yurii.karpliuk.svitmovie.repository.spec.MovieSpecification;
import yurii.karpliuk.svitmovie.service.MovieService;


import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<MovieResponse> findAllMovies(Pageable pageable) {

        Page<Movie> movies = movieRepository.findAll(pageable);

        Page<MovieResponse> movieResponses = movies.map(entity -> {
            MovieResponse dto = buildMovieResponse(entity);
            return dto;
        });


        return movieResponses;
    }


    @Override
    public MovieResponse getOneById(Long id) {
        return buildMovieResponse(movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie with id: " + id + " does not exist")));
    }

    @Override
    public MovieResponse buildMovieResponse(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setDuration(movie.getDuration());
        movieResponse.setYear(movie.getYear());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setMinAge(movie.getMinAge());
        movieResponse.setImageUrl(movie.getImageUrl());
        movieResponse.setDirector(movie.getDirector());
        movieResponse.setId(movie.getId());
        movieResponse.setLanguage(movie.getLanguage());
        movieResponse.setStartDate(movie.getStartDate());
        movieResponse.setEndDate(movie.getEndDate());
        movieResponse.setActorsInitials(movie.getActors().stream()
                .map(actor -> String.join(" ", actor.getFirstName(), actor.getLastName()))
                .collect(Collectors.toList()));
        movieResponse.setCategories(movie.getCategories().stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList()));
        return movieResponse;
    }


    public Page<MovieResponse> searchByTitleOfMovieLike(Pageable pageable,String movieTitle) {
        Page<Movie> movies = movieRepository.findAllByTitleLike("%" + movieTitle + "%",pageable);
        Page<MovieResponse> movieResponses = movies.map(entity -> {
            MovieResponse dto = buildMovieResponse(entity);
            return dto;
        });

        return movieResponses;
    }

    @Override
    public Page<MovieResponse> search(Pageable pageable, String categoryName) {

        MovieSpecification movieSpecification = new MovieSpecification(categoryName);
        Page<Movie> movies =  movieRepository.findAll(movieSpecification, pageable);
        Page<MovieResponse> movieResponses = movies.map(entity -> {
            MovieResponse dto = buildMovieResponse(entity);
            return dto;
        });


        return movieResponses;
    }

}
