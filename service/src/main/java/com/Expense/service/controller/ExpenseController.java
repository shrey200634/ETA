package com.Expense.service.controller;


import com.Expense.service.dto.Expensedto;
import com.Expense.service.service.ExpenseService;
import jakarta.websocket.server.PathParam;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    ExpenseController(ExpenseService expenseService){
        this.expenseService= expenseService;

    }

    @GetMapping("/expense/v1/")
   public  ResponseEntity<List<Expensedto>> getExpensse(@PathParam("user_id") @NonNull String userId){
        try{
            List<Expensedto> expensedtoList= expenseService.getExpenses(userId);
            return new ResponseEntity<>(expensedtoList , HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND);

        }
    }
}
