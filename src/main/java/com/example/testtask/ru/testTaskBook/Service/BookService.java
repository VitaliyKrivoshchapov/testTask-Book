package com.example.testtask.ru.testTaskBook.Service;

import com.example.testtask.ru.testTaskBook.Entity.Book;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book  getBookById(long id);
    Book updateBook(Book book, long id);
    void deleteBook(long id);


}
