package com.tau.springbootlibrary.controller;

import com.tau.springbootlibrary.entity.Message;
import com.tau.springbootlibrary.requestmodels.AdminQuestionRequest;
import com.tau.springbootlibrary.service.MessagesService;
import com.tau.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessagesController {

    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping("/secure/add/message")
    public void postMessage(JwtAuthenticationToken jwtAuthenticationToken,
                            @RequestBody Message messageRequest) {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        messagesService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value="Authorization") String token,
                           JwtAuthenticationToken jwtAuthenticationToken,
                           @RequestBody AdminQuestionRequest adminQuestionRequest)
            throws Exception {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();

        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only.");
        }
        messagesService.putMessage(adminQuestionRequest, userEmail);
    }

}














