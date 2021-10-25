
package com.example.testtask.ru.testTaskBook.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")

public class Book implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @Column(name ="nameBook")
        private String nameBook;

        @Column(name ="year")
        private int year;

        @Column(name = "author")
        private String author;

        @Column(name = "isbn")
        private int isbn;

        @Column(name = "reader")
        private String reader;

}

