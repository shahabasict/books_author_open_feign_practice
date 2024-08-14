package com.ust.BookService.controller;

import com.ust.BookService.dto.AuthorDto;
import com.ust.BookService.dto.BookDto;
import com.ust.BookService.feign.AuthorClient;
import com.ust.BookService.model.Book;
import com.ust.BookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class BookController {

    private final BookRepository bookRepository;

    private final AuthorClient authorClient;

    public BookController(BookRepository bookRepository, AuthorClient authorClient) {
        this.bookRepository = bookRepository;
        this.authorClient = authorClient;
    }

    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> {
            AuthorDto authorDto = authorClient.getAuthorById(book.getAuthorId());
            return new BookDto(book.getId(), book.getBookName(), authorDto);
        }).toList();
    }

    @GetMapping("/books/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            return null;
        }

        AuthorDto authorDto = authorClient.getAuthorById(book.getAuthorId());
        return new BookDto(book.getId(), book.getBookName(), authorDto);
    }


}