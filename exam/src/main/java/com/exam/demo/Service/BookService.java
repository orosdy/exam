package com.exam.demo.Service;

import com.exam.demo.Model.Book;
import com.exam.demo.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public Book create(Book b){
        return bookRepository.save(b);
    }

    // READ
    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }

    // READ by Id (ISBN)
    public Book getById(Long isbn){
        Optional<Book> oBook = bookRepository.findById(isbn);
        if( oBook.isPresent() ){
            return oBook.get();
        }
        else{
            throw new NoResultException("Nincs ilyen 'book' objektum.");
        }
    }

    // UPDATE
    public Book update(Book b){
        return bookRepository.save(b);
    }

    // DELETE
    public void Delete(Long isbn){
        bookRepository.deleteById(isbn);
    }

    // JPQL
    public List<Book> findByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        if( !CollectionUtils.isEmpty(books) ) {
            return books;
        }
        throw new NoResultException("Nincs találat");
    }

    public List<Book> findByPublisher(String publisher) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        if( !CollectionUtils.isEmpty(books) ) {
            return books;
        }
        throw new NoResultException("Nincs találat");
    }

}
