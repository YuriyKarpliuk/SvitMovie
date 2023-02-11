package yurii.karpliuk.svitmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yurii.karpliuk.svitmovie.dto.response.MovieResponse;
import yurii.karpliuk.svitmovie.entity.Category;
import yurii.karpliuk.svitmovie.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.findAllMovieCategories();
    }
}
