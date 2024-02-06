package com.ichwan.graphspring.service;

import com.ichwan.graphspring.dto.AuthorInput;
import com.ichwan.graphspring.entity.Author;
import com.ichwan.graphspring.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Author create(AuthorInput authorInput){
        Author author = new Author();
        author.setName(authorInput.name());
        return authorRepository.save(author);
    }

    public Optional<Author> getById(Long id){
        return authorRepository.findById(id);
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @Transactional
    public Author update(AuthorInput authorInput, Long id){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID not found"));
        author.setName(authorInput.name());
        return authorRepository.save(author);
    }

    @Transactional
    public void delete(Long id){
        authorRepository.deleteById(id);
    }
}
