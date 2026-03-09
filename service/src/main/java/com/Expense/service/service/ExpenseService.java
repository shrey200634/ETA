package com.Expense.service.service;

import com.Expense.service.dto.Expensedto;
import com.Expense.service.entity.Expense;
import com.Expense.service.repo.ExpenseRepo;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

   public boolean createExpense(Expensedto expensedto){

      setCurrency( expensedto);
      try{
         expenseRepo.save(objectMapper.convertValue(expensedto, Expense.class));
         return true;

      }catch (Exception ex){
          return  false ;
      }
   }


   public boolean updateExpense(Expensedto expensedto){
      Optional<Expense> expenseFoundOpt =expenseRepo.findByUserIdAndExternalId(expensedto.getUserId() , expensedto.getExternalId());
      if (expenseFoundOpt.isEmpty()){
         return  false;
      }
      Expense expense=expenseFoundOpt.get();
      expense.setCurrency(Strings.isNotBlank(expensedto.getCurrency())? expensedto.getCurrency() : expense.getCurrency());
      expense.setMerchant(Strings.isNotBlank(expensedto.getMerchant())? expensedto.getMerchant() : expense.getMerchant());
      expense.setAmount(expensedto.getAmount());// we not check this because this cannt be null
      expenseRepo.save(expense);
      return  true ;


   }



   public List<Expensedto> getExpenses(String userId){
      List<Expense> expenseList = expenseRepo.findByUserId(userId);
      return  objectMapper.convertValue(expenseList, new TypeReference<List<Expensedto>>() {});
   }


   private void setCurrency(Expensedto expensedto){
      if (Objects.isNull(expensedto.getCurrency())){
         expensedto.setCurrency("inr");
      }
   }

}
