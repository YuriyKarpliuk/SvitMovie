package yurii.karpliuk.svitmovie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Hall extends IdHolder {
    private String name;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "hall_to_seat", joinColumns = @JoinColumn(name = "hall_id"), inverseJoinColumns = @JoinColumn(name = "seat_id"))
    private List<Seat> seats;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private ScreenTechnology screenTechnology;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Cinema cinema;

}
