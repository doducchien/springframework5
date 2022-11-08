package com.example.springframework5.bootstrap;

import com.example.springframework5.domain.Author;
import com.example.springframework5.domain.Book;
import com.example.springframework5.domain.Publisher;
import com.example.springframework5.repository.AuthorRepository;
import com.example.springframework5.repository.BookRepository;
import com.example.springframework5.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private  final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Nguyen", "A");
        Book book1 = new Book("Book 1", "903284092");
        Publisher publisher = new Publisher("NXB Kim Dong", "Hoang Mai", "Ha noi", "Viet nam", "1000000");
        Publisher savePublisher = publisherRepository.save(publisher);

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        publisher.getBooks().add(book1);
        book1.setPublisher(publisher);

        Author author = authorRepository.save(author1);
        Book book = bookRepository.save(book1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println(book.getAuthors().stream().collect(Collectors.toList()).get(0).getFirstName());
        System.out.println(author.getBooks().stream().collect(Collectors.toList()).get(0).getTitle());
        System.out.println(book.getPublisher().getName());

        System.out.println(savePublisher.getBooks().stream().collect(Collectors.toList()).get(0).getTitle());

    }
}
