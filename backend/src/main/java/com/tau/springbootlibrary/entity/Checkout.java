package com.tau.springbootlibrary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "checkout")
@Data
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "checkout_date")
    private String chekoutDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "book_id")
    private Long bookId;

    public Checkout() {
    }

    public Checkout(String userEmail, String chekoutDate, String returnDate,
                    Long bookId) {
        this.userEmail = userEmail;
        this.chekoutDate = chekoutDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
    }
}
