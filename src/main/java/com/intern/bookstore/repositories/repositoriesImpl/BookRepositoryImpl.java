package com.intern.bookstore.repositories.repositoriesImpl;

import com.intern.bookstore.models.Book;
import com.intern.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        Query query = entityManager.createQuery("from Book");
        return query.getResultList();
    }

    @Override
    public Book findById(int id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    public void save(Book book) {
        Book dbBook = entityManager.merge(book);
        book.setId(dbBook.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Book  where id=: bookId");
        query.setParameter("bookId", id);
        query.executeUpdate();
    }
}
