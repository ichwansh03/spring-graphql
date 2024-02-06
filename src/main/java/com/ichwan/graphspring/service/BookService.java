package com.ichwan.graphspring.service;

import com.ichwan.graphspring.dto.BookInput;
import com.ichwan.graphspring.entity.Author;
import com.ichwan.graphspring.entity.Book;
import com.ichwan.graphspring.repository.AuthorRepository;
import com.ichwan.graphspring.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Book create(BookInput bookInput) {
        Author author = authorRepository.findById(bookInput.authorId())
                .orElseThrow(() -> new EntityNotFoundException("ID not found"));
        Book book = new Book();
        book.setTitle(bookInput.title());
        book.setPublisher(book.getPublisher());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public Optional<Book> getById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book update(BookInput bookInput, Long id) {
        Author author = authorRepository.findById(bookInput.authorId())
                .orElseThrow(() -> new EntityNotFoundException("ID not found"));
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID not found"));
        book.setTitle(bookInput.title());
        book.setPublisher(bookInput.publisher());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Transactional
    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
