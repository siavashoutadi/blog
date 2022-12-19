package com.outadi.siavash.reactiverestapi.service;

import com.outadi.siavash.reactiverestapi.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface  BookService {
    Flux<Book> getBooks();

    Mono<Book> getBookById(String bookId);
}
