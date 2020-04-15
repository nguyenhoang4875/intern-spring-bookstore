package com.intern.bookstore.repositories;

import com.intern.bookstore.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository {

    public List<Book> findAll();

    public Book findById(int id);

    public void save(Book book);

    public void deleteById(int id);


}
