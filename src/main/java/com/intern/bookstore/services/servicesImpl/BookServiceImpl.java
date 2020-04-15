package com.intern.bookstore.services.servicesImpl;

import com.intern.bookstore.models.Book;
import com.intern.bookstore.repositories.BookRepository;
import com.intern.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
