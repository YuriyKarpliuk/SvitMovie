package yurii.karpliuk.svitmovie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Actor extends IdHolder {

    private String firstName;

    private String lastName;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "actor_to_movie", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName) && Objects.equals(movies, actor.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, movies);
    }
}
