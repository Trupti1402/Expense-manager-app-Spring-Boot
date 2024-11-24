
package com.itshaala.expensemgrapp.Controller;

import com.itshaala.expensemgrapp.Model.Expense;
import com.itshaala.expensemgrapp.Service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<String> createExpense(@RequestBody Expense expense) {
        expenseService.createExpense(expense);
        return new ResponseEntity("expense created successfully", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return new ResponseEntity("expense updated successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return expenseService.getAllExpense();
    }

    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpensesById(id);
    }

    @GetMapping("/filter")
    public List<Expense> getExpensesByFilter(@RequestParam("name") String name, @RequestParam("desc") String desc) {
        Expense expense = Expense.builder().expenseName(name).expenseDescription(desc).build();
        return expenseService.getExpensesByFilter(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return new ResponseEntity<>("Expense deleted", HttpStatus.OK);
    }

}