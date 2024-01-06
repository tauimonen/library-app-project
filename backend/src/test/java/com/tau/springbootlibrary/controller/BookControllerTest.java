package com.tau.springbootlibrary.controller;

import com.tau.springbootlibrary.entity.Book;
import com.tau.springbootlibrary.responsemodels.ShelfCurrentLoansResponse;
import com.tau.springbootlibrary.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCurrentLoans() throws Exception {
        // Arrange
        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user@example.com");

        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt, null);
        List<ShelfCurrentLoansResponse> expectedResponse = Arrays.asList(new ShelfCurrentLoansResponse(), new ShelfCurrentLoansResponse());
        when(bookService.currentLoans(anyString())).thenReturn(expectedResponse);

        // Act
        List<ShelfCurrentLoansResponse> actualResponse = bookController.currentLoans(token);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(bookService, times(1)).currentLoans(anyString());
    }

    @Test
    void testCurrentLoansCount() {
        // Arrange
        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user@example.com");

        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt, null);
        int expectedCount = 5;
        when(bookService.currentLoansCount(anyString())).thenReturn(expectedCount);

        // Act
        int actualCount = bookController.currentLoansCount(token);

        // Assert
        assertEquals(expectedCount, actualCount);
        verify(bookService, times(1)).currentLoansCount(anyString());
    }

    @Test
    void testCheckoutBookByUser() {
        // Arrange
        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user@example.com");

        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt, null);
        Long bookId = 123L;

        when(bookService.checkoutBookByUser(anyString(), eq(bookId))).thenReturn(true);

        // Act
        Boolean result = bookController.checkoutBookByUser(token, bookId);

        // Assert
        assertEquals(true, result);
        verify(bookService, times(1)).checkoutBookByUser(anyString(), eq(bookId));
    }

    @Test
    void testCheckoutBook() throws Exception {
        // Arrange
        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user@example.com");

        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt, null);
        Long bookId = 123L;

        Book expectedBook = new Book(); // You can customize this as needed
        when(bookService.checkoutBook(anyString(), eq(bookId))).thenReturn(expectedBook);

        // Act
        Book result = bookController.checkoutBook(token, bookId);

        // Assert
        assertEquals(expectedBook, result);
        verify(bookService, times(1)).checkoutBook(anyString(), eq(bookId));
    }

    @Test
    void testReturnBook() throws Exception {
        // Arrange
        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user@example.com");

        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt, null);
        Long bookId = 123L;

        // Act
        bookController.returnBook(token, bookId);

        // Assert
        verify(bookService, times(1)).returnBook(anyString(), eq(bookId));
    }

    @Test
    void testRenewLoan() throws Exception {
        // Arrange
        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user@example.com");

        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt, null);
        long bookId = 123L;

        // Act
        bookController.renewLoan(token, bookId);

        // Assert
        verify(bookService, times(1)).renewLoan(anyString(), eq(bookId));
    }
}
