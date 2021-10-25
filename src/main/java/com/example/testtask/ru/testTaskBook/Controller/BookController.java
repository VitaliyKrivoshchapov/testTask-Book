package com.example.testtask.ru.testTaskBook.Controller;

import com.example.testtask.ru.testTaskBook.Service.BookServiceImpl;
import com.example.testtask.ru.testTaskBook.Entity.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        //System.out.println("Работает saveBook");
        return  new ResponseEntity<Book>(bookServiceImpl.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Book> getAll(){
        //System.out.println("Работает getAll");
        return bookServiceImpl.getAllBooks();
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById( @PathVariable("id") long id){
        //System.out.println("Работает getBookById" + id);
        return new ResponseEntity<Book>(bookServiceImpl.getBookById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book ){
       //Работает
        //System.out.println("Работает put на обновление");
        return new ResponseEntity<Book>(bookServiceImpl.updateBook(book,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") long id){
        System.out.println("Удаляем " + getBookById(id));
        bookServiceImpl.deleteBook(id);
        return  new ResponseEntity<String>("Book was delete", HttpStatus.OK);
    }

}
