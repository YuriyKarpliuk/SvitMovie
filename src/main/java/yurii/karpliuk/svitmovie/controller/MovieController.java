package yurii.karpliuk.svitmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import yurii.karpliuk.svitmovie.dto.response.MovieResponse;
import yurii.karpliuk.svitmovie.service.MovieService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public Page<MovieResponse> getAll(Pageable pageable) {
        return movieService.findAllMovies(pageable);
    }

    @GetMapping("/{id}")
    public MovieResponse getOneById(@PathVariable Long id) {
        return movieService.getOneById(id);
    }

    @GetMapping("/all/categoryName/{categoryName}")
    public Page<MovieResponse> searchMoviesByCategoryName(Pageable pageable, @PathVariable String categoryName) {
        return movieService.search(pageable, categoryName);
    }

    @GetMapping("/searchByTitleLike")
    public Page<MovieResponse> searchByTitleOfMovieLike(Pageable pageable, @RequestParam String movieTitle) {
        return movieService.searchByTitleOfMovieLike(pageable, movieTitle);
    }
}
