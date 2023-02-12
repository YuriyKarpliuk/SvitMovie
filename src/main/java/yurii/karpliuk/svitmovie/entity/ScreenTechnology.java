package yurii.karpliuk.svitmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "screenTechnologies")
public class ScreenTechnology extends IdHolder{
    private String nameOfType;
    @OneToMany(mappedBy = "screenTechnology", cascade = CascadeType.ALL)
    private List<Hall> halls;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScreenTechnology that = (ScreenTechnology) o;
        return Objects.equals(nameOfType, that.nameOfType) && Objects.equals(halls, that.halls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameOfType, halls);
    }
}
