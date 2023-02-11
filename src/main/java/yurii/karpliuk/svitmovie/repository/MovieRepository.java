package yurii.karpliuk.svitmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import yurii.karpliuk.svitmovie.entity.Movie;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>, JpaSpecificationExecutor<Movie> {
}
