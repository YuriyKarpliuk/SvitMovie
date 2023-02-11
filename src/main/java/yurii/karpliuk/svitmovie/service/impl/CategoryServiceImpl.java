package yurii.karpliuk.svitmovie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yurii.karpliuk.svitmovie.entity.Category;
import yurii.karpliuk.svitmovie.repository.CategoryRepository;
import yurii.karpliuk.svitmovie.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllMovieCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
