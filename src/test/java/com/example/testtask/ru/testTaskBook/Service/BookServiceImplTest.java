package com.example.testtask.ru.testTaskBook.Service;

import com.example.testtask.ru.testTaskBook.Model.Book;
import com.example.testtask.ru.testTaskBook.Reposittory.BookRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
//попробовать @Spy
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService;


    @Test
    void saveBook() {
        Book book = new Book();
        book.setId(1);
        book.setNameBook("Капитанская дочка");
        book.setYear(1936);
        book.setReader("Иванов");
        book.setIsbn(1);
        when (this.bookRepository.save(any())).thenReturn(book);
        Book resultBook = this.bookService.saveBook(book);
        //Book = this.bookService.getBookById(1);
        System.out.println(resultBook.getId());
        Assert.assertEquals(1,resultBook.getId());
        Assert.assertEquals("Капитанская дочка",resultBook.getNameBook());
        Assert.assertEquals(1936,resultBook.getYear());
        Assert.assertEquals("Иванов",resultBook.getReader());
        Assert.assertEquals(1,resultBook.getIsbn());
    }

    @Test
    void getAllBooks() {
    }

    @Test
    void getBookById() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBook() {
    }
}