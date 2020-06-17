package com.exam.demo.Service;

import com.exam.demo.Model.Genre;
import com.exam.demo.Repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    // CREATE
    public Genre create(Genre g){
        return genreRepository.save(g);
    }

    // READ
    public List<Genre> getAll(){
        return (List<Genre>) genreRepository.findAll();
    }

    // READ by Id (ISBN)
    public Genre getById(Long genreID){
        Optional<Genre> oGenre = genreRepository.findById(genreID);
        if( oGenre.isPresent() ){
            return oGenre.get();
        }
        else{
            throw new NoResultException("Nincs ilyen 'genre' objektum.");
        }
    }

    // UPDATE
    public Genre update(Genre b){
        return genreRepository.save(b);
    }

    // DELETE
    public void Delete(Long genreID){
        genreRepository.deleteById(genreID);
    }

    // JPQL
    public List<Genre> findByForm(String form) {
        List<Genre> genres = genreRepository.findByForm(form);
        if( !CollectionUtils.isEmpty(genres) ) {
            return genres;
        }
        throw new NoResultException("Nincs találat");
    }

    public List<Genre> findBySeries(String series) {
        List<Genre> genres = genreRepository.findBySeries(series);
        if( !CollectionUtils.isEmpty(genres) ) {
            return genres;
        }
        throw new NoResultException("Nincs találat");
    }

}
