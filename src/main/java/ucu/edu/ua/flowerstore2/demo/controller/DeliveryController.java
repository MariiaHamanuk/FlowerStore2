package ucu.edu.ua.flowerstore2.demo.controller;

// import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ucu.edu.ua.flowerstore2.demo.payment.CreditCardPaymentStrategy;
import ucu.edu.ua.flowerstore2.demo.payment.Payment;

@RequestMapping("/Delivery")
@RestController
public class DeliveryController {
    @GetMapping("/DHL")
    public double byDHL(@RequestParam double p){
        Payment pay = new CreditCardPaymentStrategy();
        return pay.pay(p);
    }
    @GetMapping("/Postal")
    public double byPostal(@RequestParam double p){
        Payment pay = new CreditCardPaymentStrategy();
        return pay.pay(p);
    }
}
