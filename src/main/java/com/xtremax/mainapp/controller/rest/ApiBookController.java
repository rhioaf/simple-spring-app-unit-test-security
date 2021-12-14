package com.xtremax.mainapp.controller.rest;

import com.xtremax.mainapp.errorresponse.NotFound;
import com.xtremax.mainapp.model.Book;
import com.xtremax.mainapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/book")
public class ApiBookController {
  // Example of OneToMany Relationship
  // By adding annotations (OneToMany and JoinColumn) on attribute storyList
  // Those annotation tells Spring that :
  // - Book has many Story (cause type of attribute is List<Story>)
  // - And Every Story only has one Book
  // - Property from annotation JoinColumn :
  //      > name means the foreign key (So this column will be present in table Story)
  //      > referencedColumnName means that foreign key is linked to primary key of current table (Book)
  // This type OneToMany relationship is UNIDIRECTIONAL, it means that navigate access to one side only
  // Book -----> Story
  // On the next Example, there is BIDIRECTIONAL type it means that navigate access for both side.

  @Autowired
  private BookService bookService;

  @PostMapping(value = {"", "/"})
  public Book saveBook(@RequestBody Book book) {
    Book result = bookService.saveBook(book);
    return result;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
    try {
      Book result = bookService.findByBookId(id);
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(new NotFound("Couldn't find book!."), HttpStatus.NOT_FOUND);
    }
  }
}
