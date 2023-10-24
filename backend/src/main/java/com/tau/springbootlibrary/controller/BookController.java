package com.tau.springbootlibrary.controller;

import com.tau.springbootlibrary.entity.Book;
import com.tau.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication
        .JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(JwtAuthenticationToken
                                             jwtAuthenticationToken) {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        return bookService.currentLoansCount(userEmail);
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(JwtAuthenticationToken
                                                  jwtAuthenticationToken,
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
}
