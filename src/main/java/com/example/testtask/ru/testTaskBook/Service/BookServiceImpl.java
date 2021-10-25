package com.example.testtask.ru.testTaskBook.Service;

import com.example.testtask.ru.testTaskBook.Model.Book;
import com.example.testtask.ru.testTaskBook.Exception.ResourceNotFoundException;
import com.example.testtask.ru.testTaskBook.Reposittory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    public BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
/*      Optional<Book>  book = bookRepository.findById(id);
       if (book.isPresent()){
           return book.get();
       }else
           throw new ResourceNotFoundException("Book","id",id);
    }*/
       return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
}

    @Override
    public Book updateBook(Book book, long id) {
        Book existingBook = bookRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Book","id",id));
        existingBook.setNameBook(book.getNameBook());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setYear(book.getYear());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setReader(book.getReader());
        bookRepository.save(existingBook);
        return existingBook  ;
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Book","id",id));
        bookRepository.deleteById(id);
    }


}
