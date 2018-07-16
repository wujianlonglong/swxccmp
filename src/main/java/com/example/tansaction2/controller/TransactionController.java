package com.example.tansaction2.controller;


import com.example.tansaction2.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {


    @Autowired
    TransactionService transactionService;

    @RequestMapping("/t")
    public void test() throws InterruptedException {
        transactionService.saveUser();
    }
}
