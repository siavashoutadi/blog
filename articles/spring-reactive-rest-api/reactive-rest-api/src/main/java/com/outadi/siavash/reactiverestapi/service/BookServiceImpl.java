package com.outadi.siavash.reactiverestapi.service;

import com.outadi.siavash.reactiverestapi.model.Book;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {
  List<Book> BOOKS = generateBooks();

  @Override
  public Flux<Book> getBooks() {
    return Flux.fromIterable(BOOKS);
  }

  @Override
  public Mono<Book> getBookById(String bookId) {
    for (Book book : BOOKS) {
      if (book.getId().equals(bookId)) {
        return Mono.just(book);
      }
    }

    throw new RuntimeException("Book not found!");
  }

  private List<Book> generateBooks() {
    List<Book> books = new ArrayList<>();
    IntStream.range(0, 5).forEachOrdered(n -> {
      books.add(generateBook());
    });

    return books;
  }

  private Book generateBook() {
    String id = UUID.randomUUID().toString();
    int page = new Random().nextInt(100) + 100;
    Instant instance = Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt());
    LocalDate publishedDate = LocalDate.ofInstant(instance, ZoneId.systemDefault());
    return new Book(id, "Book " + id, publishedDate, page);
  }
}
