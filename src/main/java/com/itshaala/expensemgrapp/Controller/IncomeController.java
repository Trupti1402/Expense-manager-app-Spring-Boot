
package com.itshaala.expensemgrapp.Controller;

import com.itshaala.expensemgrapp.Model.Income;
import com.itshaala.expensemgrapp.Service.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/income")
@AllArgsConstructor
public class IncomeController {

    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<String> createIncome(@RequestBody Income income) {
        incomeService.createIncome(income);
        return new ResponseEntity("income created successfully", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateIncome(@RequestBody Income income) {
        incomeService.updateIncome(income);
        return new ResponseEntity("income updated successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Income> getAllIncome() {
        return incomeService.getAllIncomes();
    }

    @GetMapping("/{id}")
    public Optional<Income> getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomesById(id);
    }

    @GetMapping("/filter")
    public List<Income> getIncomesByFilter(@RequestParam("name") String name, @RequestParam("desc") String desc) {
        Income income = Income.builder().incomeName(name).incomeDescription(desc).build();
        return incomeService.getIncomesByFilter(income);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIncomeById(@PathVariable Long id) {
        incomeService.deleteIncomeById(id);
        return new ResponseEntity<>("Income deleted", HttpStatus.OK);
    }

}