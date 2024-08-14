package com.ust.BookService.dto;

public record AuthorDto(Long id, String name) {
    public AuthorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
