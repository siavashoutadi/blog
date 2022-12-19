package com.outadi.siavash.reactiverestapi.controller;

import com.outadi.siavash.reactiverestapi.model.Book;
import com.outadi.siavash.reactiverestapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(BookResource.API_V1_BOOK)
public class BookResource {
  static final String API_V1_BOOK = "/api/v1/book";

  @Autowired
  private BookService bookService;

  @GetMapping(path = "{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Book> getBookById(@PathVariable String bookId) {
    return bookService.getBookById(bookId);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<Book> getBookById() {
    return bookService.getBooks();
  }
}
