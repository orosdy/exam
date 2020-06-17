package com.exam.demo.Repository;

import com.exam.demo.Model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    @Query(value = "select b from Book b where author = :author")
    List<Book> findByAuthor(@Param("author") String author );

    @Query(value = "select b from Book b where publisher = :publisher")
    List<Book> findByPublisher(@Param("publisher") String publisher );

}
