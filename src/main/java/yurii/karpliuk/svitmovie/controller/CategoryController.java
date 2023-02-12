package yurii.karpliuk.svitmovie.controller;

import org.springframework.web.bind.annotation.*;
import yurii.karpliuk.svitmovie.entity.Category;
import yurii.karpliuk.svitmovie.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.findAllMovieCategories();
    }
}
