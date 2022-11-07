package com.example.springframework5.repository;

import com.example.springframework5.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
