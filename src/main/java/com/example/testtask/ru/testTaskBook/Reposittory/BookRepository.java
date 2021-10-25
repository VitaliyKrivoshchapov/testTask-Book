package com.example.testtask.ru.testTaskBook.Reposittory;

import com.example.testtask.ru.testTaskBook.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
