package com.example.testtask.ru.testTaskBook.Service;

import com.example.testtask.ru.testTaskBook.Model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book  getBookById(long id);
    Book updateBook(Book book, long id);
    void deleteBook(long id);


}
