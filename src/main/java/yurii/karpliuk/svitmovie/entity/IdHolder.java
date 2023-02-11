package yurii.karpliuk.svitmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter @Setter
@MappedSuperclass
public class IdHolder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdHolder idHolder = (IdHolder) o;
        return Objects.equals(id, idHolder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
