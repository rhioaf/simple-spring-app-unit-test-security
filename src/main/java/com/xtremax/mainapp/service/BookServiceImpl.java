package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.Book;
import com.xtremax.mainapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

  @Autowired
  private BookRepository repository;

  @Override
  public Book saveBook(Book book) {
    book = repository.save(book);
    return book;
  }

  @Override
  public Book findByBookId(Long id) {
    Book result = repository.findById(id).get();
    return result;
  }
}
