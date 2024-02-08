package com.ichwan.graphspring;

import com.ichwan.graphspring.entity.Author;
import com.ichwan.graphspring.entity.Book;
import com.ichwan.graphspring.repository.AuthorRepository;
import com.ichwan.graphspring.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphSpringApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author abdul = authorRepository.save(new Author("Abdullah"));
			Author andi = authorRepository.save(new Author("Andi"));
			bookRepository.saveAll(List.of(
					new Book("Ensiklopedia Muslim","Gramedia",abdul),
					new Book("Khalifah Umar","Gramedia",andi),
					new Book("Khalifah Abu Bakar","Gramedia",abdul)
			));
		};
	}
}
