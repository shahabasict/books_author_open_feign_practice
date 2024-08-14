package com.ust.BookService.feign;

import com.ust.BookService.dto.AuthorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authors", url = "http://localhost:8200/Author")
public interface AuthorClient {
    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id);
}
