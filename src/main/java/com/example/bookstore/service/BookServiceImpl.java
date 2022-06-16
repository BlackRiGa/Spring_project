package com.example.bookstore.service;

import com.example.bookstore.dao.BookEntity;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.mapper.BookToEntityMapper;
import com.example.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookToEntityMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found: id = " + id));

        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    @Override
    public void editBook(Book book) {
        if (!bookRepository.existsById(book.getId()))
            throw new NotFoundException("Book not found: id = " + book.getId());
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    @Override
    public void deleteBook(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
    }
}
