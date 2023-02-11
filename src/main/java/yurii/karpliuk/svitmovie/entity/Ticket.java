package yurii.karpliuk.svitmovie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Ticket extends IdHolder {

    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Spectacle spectacle;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;


}
