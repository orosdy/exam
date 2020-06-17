package com.exam.demo.Repository;

import com.exam.demo.Model.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository<Genre,Long> {

    @Query(value = "select g from Genre g where form = :form")
    List<Genre> findByForm(@Param("form") String form );

    @Query(value = "select g from Genre g where series = :series")
    List<Genre> findBySeries(@Param("series") String series );

}
