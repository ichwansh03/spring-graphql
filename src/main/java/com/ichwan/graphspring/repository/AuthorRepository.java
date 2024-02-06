package com.ichwan.graphspring.repository;

import com.ichwan.graphspring.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
