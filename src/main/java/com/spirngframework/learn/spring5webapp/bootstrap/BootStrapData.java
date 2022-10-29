package com.spirngframework.learn.spring5webapp.bootstrap;

import com.spirngframework.learn.spring5webapp.domain.Author;
import com.spirngframework.learn.spring5webapp.domain.Book;
import com.spirngframework.learn.spring5webapp.repositories.AuthorRepository;
import com.spirngframework.learn.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Design Deriven", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Jhonson");
        Book noEjb = new Book("J2EE Development without EJB", "3456");

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        authorRepository.saveAll(List.of(eric, rod));
        bookRepository.saveAll(List.of(ddd, noEjb));

        System.out.println("Started in bootstrap");
        System.out.println("Number of books " + bookRepository.count());

    }
}
