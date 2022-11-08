package com.example.springframework5.repository;


import com.example.springframework5.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    List<Publisher> findAll();
}
