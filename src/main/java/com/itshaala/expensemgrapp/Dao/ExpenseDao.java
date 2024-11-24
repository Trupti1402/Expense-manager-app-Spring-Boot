package com.itshaala.expensemgrapp.Dao;

import com.itshaala.expensemgrapp.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long> {

    List<Expense> findByExpenseNameContainingOrExpenseDescriptionContaining(String ExpenseName, String ExpenseDescription);

}