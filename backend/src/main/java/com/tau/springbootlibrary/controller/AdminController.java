package com.tau.springbootlibrary.controller;

import com.tau.springbootlibrary.requestmodels.AddBookRequest;
import com.tau.springbootlibrary.service.AdminService;
import com.tau.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/secure/increase/book/quantity")
    public void increaseBookQuantity(JwtAuthenticationToken jwtAuthenticationToken,
                                     @RequestParam Long bookId) throws Exception {
        String admin = jwtAuthenticationToken.getToken().getSubject();
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.increaseBookQuantity(bookId);
    }

    @PutMapping("/secure/decrease/book/quantity")
    public void decreaseBookQuantity(JwtAuthenticationToken jwtAuthenticationToken,
                                     @RequestParam Long bookId) throws Exception {
        String admin = jwtAuthenticationToken.getToken().getSubject();
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.decreaseBookQuantity(bookId);
    }

    @PostMapping("/secure/add/book")
    public void postBook(JwtAuthenticationToken jwtAuthenticationToken,
                         @RequestBody AddBookRequest addBookRequest) throws Exception {
        String admin = jwtAuthenticationToken.getToken().getSubject();
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.postBook(addBookRequest);
    }

    @DeleteMapping("/secure/delete/book")
    public void deleteBook(JwtAuthenticationToken jwtAuthenticationToken,
                           @RequestParam Long bookId) throws Exception {
        String admin = jwtAuthenticationToken.getToken().getSubject();
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.deleteBook(bookId);
    }

}












