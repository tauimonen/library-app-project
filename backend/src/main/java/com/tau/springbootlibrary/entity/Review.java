package com.tau.springbootlibrary.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "date")
    private Date date;

    @Column(name = "rating")
    private double Rating;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "review_description")
    private String reviewDescription;
}
