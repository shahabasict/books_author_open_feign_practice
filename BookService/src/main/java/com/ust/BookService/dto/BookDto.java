package com.ust.BookService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record BookDto(Long id,String title,AuthorDto authorDto) {


    public BookDto(Long id, String title, AuthorDto authorDto) {
        this.id = id;
        this.title = title;
        this.authorDto = authorDto;
    }
}
