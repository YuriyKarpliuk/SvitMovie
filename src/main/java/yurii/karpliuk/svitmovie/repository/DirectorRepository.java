package yurii.karpliuk.svitmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurii.karpliuk.svitmovie.entity.Director;
@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
}
