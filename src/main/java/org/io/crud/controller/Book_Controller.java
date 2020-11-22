package org.io.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.io.crud.model.Book;
import org.io.crud.service.Book_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Book_Controller {
    @Autowired
    Book_Service book_service;

    // get all book
    @GetMapping("/books")
    public List<Book> getBookList(){
        return book_service.getBookList();
    }
    // get book by id
    @GetMapping("/book/{id$}")
    public Book getBook(@PathVariable int id$){
        return book_service.getBook(id$);
    }
    // post all book
    @PostMapping("/books")
    public List<Book> postBookList(@RequestBody List<Book> bookList$){
        return book_service.postBookList(bookList$);
    }
    // post one book
    @PostMapping("/book")
    public Book postBook(@RequestBody Book book$){
        return book_service.postBook(book$);
    }
    // delete book by id
    @DeleteMapping("/book/{id$}")
    public String deleteBook(@PathVariable int id$){
        return book_service.deleteBook(id$);
    }
    // delete book by obj
    @DeleteMapping("/book")
    public String deleteBook(@RequestBody Book book$){
        return book_service.deleteBook(book$);
    }
    // update book
    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book$){
        return book_service.updateBook(book$);
    }
}
