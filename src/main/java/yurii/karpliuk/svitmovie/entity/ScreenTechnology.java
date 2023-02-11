package yurii.karpliuk.svitmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hallTypes")
public class HallType extends IdHolder{
    private String nameOfType;
    @OneToMany(mappedBy = "hallType", cascade = CascadeType.ALL)
    private List<Hall> halls;
}
