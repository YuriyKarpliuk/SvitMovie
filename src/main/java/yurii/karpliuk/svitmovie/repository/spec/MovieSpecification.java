package yurii.karpliuk.svitmovie.repository.spec;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import yurii.karpliuk.svitmovie.entity.Category;
import yurii.karpliuk.svitmovie.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieSpecification  implements Specification<Movie> {
    private String categoryName;


    public MovieSpecification(String categoryName) {
        this.categoryName = categoryName;
    }

    private void predicateByCategoryName(Root<Movie> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {
        if (!StringUtils.isBlank(this.categoryName)) {
            Join<Movie, Category> movieCategoryJoin = root.join("categories");
            predicates.add(criteriaBuilder.equal(movieCategoryJoin.<String>get("categoryName"),this.categoryName));
        }
    }

    @Override
    public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        predicateByCategoryName(root, criteriaBuilder, predicates);
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
