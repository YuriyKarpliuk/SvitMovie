package yurii.karpliuk.svitmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurii.karpliuk.svitmovie.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}
