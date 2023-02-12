package yurii.karpliuk.svitmovie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Spectacle extends IdHolder {

    private Timestamp sessionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Cinema cinema;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Movie movie;

}
