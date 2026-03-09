package com.Expense.service.consumer;

import com.Expense.service.dto.Expensedto;
import com.Expense.service.service.ExpenseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseConsumer {

    private  ExpenseService expenseService;

    @Autowired
    ExpenseConsumer(ExpenseService expenseService){
        this.expenseService=expenseService;

    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}" , groupId ="${spring.kafka.consumer.group-id}")
    public void listen(Expensedto expensedto){
        try{
            expenseService.createExpense(expensedto);



        }catch (Exception ex){
            System.out.println("exception is listening thee event ");        }
    }



}
