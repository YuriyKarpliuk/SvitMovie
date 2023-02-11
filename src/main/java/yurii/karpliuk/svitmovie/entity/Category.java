package yurii.karpliuk.svitmovie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Category extends IdHolder{
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private List<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName) && Objects.equals(movies, category.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, movies);
    }
}
