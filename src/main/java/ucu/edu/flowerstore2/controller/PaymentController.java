package ucu.edu.flowerstore2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ucu.edu.flowerstore2.payment.CreditCardPaymentStrategy;
import ucu.edu.flowerstore2.payment.Payment;

@RestController
@RequestMapping("/api/Payment")
public class PaymentController {
    @GetMapping("/withPayPal")
    public double withPayPal(@RequestParam double p){
        Payment pay = new CreditCardPaymentStrategy();
        return pay.pay(p);
    }
    @GetMapping("/withCreditCard")
    public double withCreditCard(@RequestParam double p){
        Payment pay = new CreditCardPaymentStrategy();
        return pay.pay(p);
    }

}
