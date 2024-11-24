package com.itshaala.expensemgrapp.Service;

import com.itshaala.expensemgrapp.Dao.ExpenseDao;
import com.itshaala.expensemgrapp.Model.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ExpenseService {

    ExpenseDao expenseDao;

    public void createExpense(Expense expense) {
            expenseDao.save(expense);
        }

    public void updateExpense(Expense expense) {
        Expense toBeDeleted = expenseDao.findById((long) expense.getExpenseId()).get();
        expenseDao.delete(toBeDeleted);
        expenseDao.save(expense);
    }

    public List<Expense> getAllExpense() {
        return expenseDao.findAll();
    }

     public Optional<Expense> getExpensesById(Long id) {
        return expenseDao.findById(id);
     }

    public void deleteExpenseById(Long id) {
        expenseDao.deleteById(id);
    }

    public List<Expense> getExpensesByFilter(Expense expense) {
        return expenseDao.findByExpenseNameContainingOrExpenseDescriptionContaining(expense.getExpenseName(),expense.getExpenseDescription());
    }
}