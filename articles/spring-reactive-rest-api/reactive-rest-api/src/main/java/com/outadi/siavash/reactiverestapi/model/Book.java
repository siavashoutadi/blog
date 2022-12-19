package com.outadi.siavash.reactiverestapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class Book {
  private String Id;
  private String title;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate publishedDate;
  private int pages;

  public Book() {
  }

  public Book(String id, String title, LocalDate publishedDate, int pages) {
    Id = id;
    this.title = title;
    this.publishedDate = publishedDate;
    this.pages = pages;
  }

  public String getId() {
    return Id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }
}
