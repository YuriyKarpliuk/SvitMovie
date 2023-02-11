package yurii.karpliuk.svitmovie.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import yurii.karpliuk.svitmovie.entity.Actor;
import yurii.karpliuk.svitmovie.entity.Category;
import yurii.karpliuk.svitmovie.entity.Director;
import yurii.karpliuk.svitmovie.entity.Spectacle;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private Long id;

    private Date startDate;
    private Date endDate;
    private String title;
    @Column(length = 5000)
    private String description;

    private String language;
    private String duration;

    private Integer year;

    private Integer minAge;

    private String imageUrl;

    private List<String> actorsInitials;

    private List<String> categories;

    private Director director;

//    private List<Spectacle> spectacles;


}
