package org.io.crud.service;

import org.io.crud.model.Book;
import org.io.crud.repository.Book_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class Book_Service {
    @Autowired
    Book_Repository book_repository;

    // get all book
    public List<Book> getBookList(){
        return book_repository.findAll();
    }
    // get book by id
    public Book getBook(@Validated int id$){
        return this.book_repository.findById(id$).orElse(null);
    }
    // post all book
    public List<Book> postBookList(@Validated List<Book> bookList$){
        return book_repository.saveAll(bookList$);
    }
    // post one book
    public Book postBook(@Validated Book book$){
        return book_repository.save(book$);
    }
    // delete book by id
    public String deleteBook(@Validated int id$){
        Book book_ = book_repository.findById(id$).orElse(null);
        if (book_ != null){
            this.book_repository.deleteById(id$);
            return "book deleted, id: "+id$+".";
        }else {
            return "book not found!";
        }
    }
    // delete book by obj
    public String deleteBook(@Validated Book book$){
        Book book_ = book_repository.findById(book$.getId()).orElse(null);
        if(book_ != null){
            book_repository.delete(book$);
            return "book deleted, id: "+book$.getId()+".";
        }else {
            return "book not found!";
        }
    }
    // update book obj
    public Book updateBook(@Validated Book book$){
        Book book_ = book_repository.findById(book$.getId()).orElse(null);
        if(book_ != null){
            book_.setSubject(book$.getSubject());
            book_.setBookName(book$.getBookName());
            book_.setWriterName(book$.getWriterName());
            book_.setPrice(book$.getPrice());

            return book_repository.save(book_);
        }else{
            return null;
        }

    }
}
