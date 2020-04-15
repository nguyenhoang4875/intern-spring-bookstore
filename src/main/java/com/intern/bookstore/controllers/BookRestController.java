package com.intern.bookstore.controllers;

import com.intern.bookstore.models.Book;
import com.intern.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook (@PathVariable int bookId){
        Book book = bookService.findById(bookId);
        if (book == null){
            throw new RuntimeException("Book is not found: "+ bookId);
        }
        return book;
    }

    @PostMapping("/books")
    public  Book addBook(@RequestBody Book book){
        book.setId(0);
        bookService.save(book);
        return book;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){
        bookService.save(book);
        return book;
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook (@PathVariable int bookId){
        Book book = bookService.findById(bookId);
        if (book == null){
            throw  new RuntimeException("Book is not found: "+bookId);
        }
        bookService.deleteById(bookId);
        return "Delete book id: "+ bookId;
    }

}
