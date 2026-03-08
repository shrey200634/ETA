package com.Expense.service.service;

import com.Expense.service.repo.ExpenseRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@AllArgsConstructor
public class ExpenseService
{
   private ExpenseRepo expenseRepo;

   private ObjectMapper objectMapper= new ObjectMapper();

   @Autowired
    ExpenseService(ExpenseRepo expenseRepo){
       this.expenseRepo= expenseRepo;

   }

//   public boolean createExpense(){
//
//   }

}
