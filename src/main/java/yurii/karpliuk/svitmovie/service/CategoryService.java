package yurii.karpliuk.svitmovie.service;

import yurii.karpliuk.svitmovie.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllMovieCategories();
}
