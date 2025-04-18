
package com.example;

import com.example.service.BankService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example");
        BankService bankService = context.getBean(BankService.class);
        bankService.transferMoney(1, 2, 100.0);
        context.close();
    }
}
