package yurii.karpliuk.svitmovie.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Director extends IdHolder{
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(firstName, director.firstName) && Objects.equals(lastName, director.lastName) && Objects.equals(movies, director.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, movies);
    }
}
