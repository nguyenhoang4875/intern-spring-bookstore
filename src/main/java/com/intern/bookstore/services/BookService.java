package com.intern.bookstore.services;

import com.intern.bookstore.models.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();

    public Book findById(int id);

    public void save(Book book);

    public void deleteById(int id);
}
