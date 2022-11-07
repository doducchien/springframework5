package com.example.springframework5.bootstrap;

import com.example.springframework5.domain.Author;
import com.example.springframework5.domain.Book;
import com.example.springframework5.repository.AuthorRepository;
import com.example.springframework5.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Author author1 = new Author("Nguyen", "A");
        Author author2 = new Author("Nguyen", "B");

        Book book1 = new Book("Book 1", "903284092");
        Book book2 = new Book("Book 2", "8912369");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        bookRepository.save(book1);
        authorRepository.save(author1);


//
//        author2.getBooks().add(book2);
//        book2.getAuthors().add(author2);
//
//        bookRepository.save(book2);
//        authorRepository.save(author2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
