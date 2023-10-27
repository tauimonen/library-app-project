package com.tau.springbootlibrary.controller;

import com.tau.springbootlibrary.entity.Book;
import com.tau.springbootlibrary.responsemodels.ShelfCurrentLoansResponse;
import com.tau.springbootlibrary.service.BookService;
import com.tau.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// React is able to call controller without CORS error when we use CrossOrigin
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/secure/currentloans")
    public List<ShelfCurrentLoansResponse> currentLoans(
            JwtAuthenticationToken jwtAuthenticationToken)
            throws Exception
    {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        return bookService.currentLoans(userEmail);
    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(JwtAuthenticationToken jwtAuthenticationToken) {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        return bookService.currentLoansCount(userEmail);
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(JwtAuthenticationToken jwtAuthenticationToken,
                                      @RequestParam Long bookId) {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook (JwtAuthenticationToken jwtAuthenticationToken,
                              @RequestParam Long bookId) throws Exception {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        return bookService.checkoutBook(userEmail, bookId);
    }

    @PutMapping("/secure/return")
    public void returnBook(JwtAuthenticationToken jwtAuthenticationToken,
                           @RequestParam Long bookId) throws Exception {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        bookService.returnBook(userEmail, bookId);
    }

    @PutMapping("/secure/renew/loan")
    public void renewLoan(JwtAuthenticationToken jwtAuthenticationToken,
                          @RequestParam Long bookId) throws Exception {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        bookService.renewLoan(userEmail, bookId);
    }
}












