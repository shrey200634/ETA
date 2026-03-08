package com.Expense.service.repo;

import com.Expense.service.entity.Expense;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepo extends CrudRepository<Expense, Long> {

    //find by userid


    List<Expense> findByUserId(String userid);

    List<Expense> findByUserIdAndCreatedAtBetween(String userId , Timestamp startTime , Timestamp endTime );


    Optional<Expense> findByUserIdAndExternalId(String userId , String externalId);

}
