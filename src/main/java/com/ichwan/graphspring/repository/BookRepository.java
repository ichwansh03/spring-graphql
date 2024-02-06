package com.ichwan.graphspring.repository;

import com.ichwan.graphspring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
