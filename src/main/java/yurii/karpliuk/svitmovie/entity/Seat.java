package yurii.karpliuk.svitmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Seat extends IdHolder {
    private Integer number;
    private Integer numberOfRow;
    private Boolean isReserved;
    @ManyToMany(mappedBy = "seats")
    private List<Hall> halls;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

}
