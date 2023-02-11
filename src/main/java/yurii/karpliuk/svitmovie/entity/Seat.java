package yurii.karpliuk.svitmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Place extends IdHolder {
    private Integer seatNumber;
    private Integer numberOfRow;
    private Boolean isReserved;
    @ManyToMany(mappedBy = "places")
    private List<Hall> halls;

    @OneToOne(mappedBy = "place")
    private Ticket ticket;

}
