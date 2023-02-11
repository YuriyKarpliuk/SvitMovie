package yurii.karpliuk.svitmovie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Session extends IdHolder {
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Hall hall;

    private Date sessionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Movie movie;
}
