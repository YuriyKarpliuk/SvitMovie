package yurii.karpliuk.svitmovie.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Movie extends IdHolder {

    private String title;
    @Column(length = 5000)
    private String description;

    private String language;

    private String duration;

    private Integer year;

    private Integer minAge;

    private String imageUrl;

    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Spectacle> spectacles;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "movie_to_category", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Director director;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(description, movie.description) && Objects.equals(duration, movie.duration) && Objects.equals(year, movie.year) && Objects.equals(minAge, movie.minAge) && Objects.equals(imageUrl, movie.imageUrl) && Objects.equals(spectacles, movie.spectacles) && Objects.equals(actors, movie.actors) && Objects.equals(categories, movie.categories) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, description, duration, year,minAge, imageUrl, spectacles, actors, categories, director);
    }
}
