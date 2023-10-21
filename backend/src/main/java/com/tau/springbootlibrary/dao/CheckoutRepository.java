package com.tau.springbootlibrary.dao;

import com.tau.springbootlibrary.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByEmailAndBookId(String userEmail, Long bookId);
}
