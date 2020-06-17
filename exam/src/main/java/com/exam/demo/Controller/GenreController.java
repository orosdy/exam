package com.exam.demo.Controller;

import com.exam.demo.Model.Genre;
import com.exam.demo.Service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // CREATE
    @PostMapping( path = "/createGenre" )
    public Genre create(@RequestBody Genre g){
        return genreService.create(g);
    }

    // READ
    @GetMapping( path = "/getAllGenres")
    public List<Genre> getAll(){
        return genreService.getAll();
    }

    // READ by Id (ISBN)
    @RequestMapping( method = RequestMethod.GET, value = "/getGenre/{genreID}")
    public Genre findById(@PathVariable("genreID") Long genreID){
        return genreService.getById(genreID);
    }

    // UPDATE
    @PostMapping( path = "/updateGenre")
    public Genre update(@RequestBody Genre g){
        return genreService.update(g);
    }

    // DELETE
    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteGenre/{genreID}")
    public void delete(@PathVariable("genreID") Long genreID){
        genreService.Delete(genreID);
    }

    // JPQL

    @GetMapping(value = "/getByForm/{form}")
    public List<Genre> findByForm(@PathVariable("form") String form){
        return genreService.findByForm(form);
    }

    @GetMapping(value = "/getSeries/{series}")
    public List<Genre> findBySeries(@PathVariable("series") String series){
        return genreService.findBySeries(series);
    }

}
