package com.tau.springbootlibrary.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.tau.springbootlibrary.requestmodels.PaymentInfoRequest;
import com.tau.springbootlibrary.service.PaymentService;
import com.tau.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/payment/secure")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(
            @RequestBody PaymentInfoRequest paymentInfoRequest)
            throws StripeException {
        PaymentIntent paymentIntent = paymentService
                .createPaymentIntent(paymentInfoRequest);
        String paymentStr = paymentIntent.toJson();

        return  new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }

    @PutMapping("/payment-complete")
    public ResponseEntity<String> stripePaymentComplete(
            JwtAuthenticationToken jwtAuthenticationToken) throws Exception {
        String userEmail = jwtAuthenticationToken.getToken().getSubject();
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }

        return paymentService.stripePayment(userEmail);
    }

}
