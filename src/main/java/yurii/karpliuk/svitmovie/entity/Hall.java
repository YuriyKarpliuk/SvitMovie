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

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Spectacle> spectacles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return Objects.equals(name, hall.name) && Objects.equals(seats, hall.seats) && Objects.equals(screenTechnology, hall.screenTechnology) && Objects.equals(spectacles, hall.spectacles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seats, screenTechnology, spectacles);
    }
}
