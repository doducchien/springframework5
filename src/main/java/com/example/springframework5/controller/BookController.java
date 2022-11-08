package com.example.springframework5.controller;


import com.example.springframework5.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBook(Model model){
        System.out.println("books");
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }

}
