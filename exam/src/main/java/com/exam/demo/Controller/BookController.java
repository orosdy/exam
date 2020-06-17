package com.exam.demo.Controller;

import com.exam.demo.Model.Book;
import com.exam.demo.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE
    @PostMapping( path = "/createBook" )
    public Book create(@RequestBody Book b){
        return bookService.create(b);
    }

    // READ
    @GetMapping( path = "/getAllBooks")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    // READ by Id (ISBN)
    @RequestMapping( method = RequestMethod.GET, value = "/getBook/{isbn}")
    public Book findById(@PathVariable("isbn") Long isbn){
        return bookService.getById(isbn);
    }

    // UPDATE
    @PostMapping( path = "/updateBook")
    public Book update(@RequestBody Book b){
        return bookService.update(b);
    }

    // DELETE
    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteBook/{isbn}")
    public void delete(@PathVariable("isbn") Long isbn){
        bookService.Delete(isbn);
    }

    // JPQL

    @GetMapping(value = "/getbyAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable("author") String author){
        return bookService.findByAuthor(author);
    }

    @GetMapping(value = "/getbyPublisher/{publisher}")
    public List<Book> findByPublisher(@PathVariable("publisher") String publisher){
        return bookService.findByPublisher(publisher);
    }

}
