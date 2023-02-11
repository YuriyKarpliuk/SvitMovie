package yurii.karpliuk.svitmovie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import yurii.karpliuk.svitmovie.entity.Movie;
import org.springframework.data.domain.Pageable;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>, JpaSpecificationExecutor<Movie> {
    Page<Movie> findAllByTitleLike(String title, Pageable pageable);
}
