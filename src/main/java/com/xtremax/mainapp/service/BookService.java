package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.Book;

public interface BookService {
  Book saveBook(Book book);
  Book findByBookId(Long id);
}
