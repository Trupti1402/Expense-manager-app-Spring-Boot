package com.itshaala.expensemgrapp.Service;

import com.itshaala.expensemgrapp.Dao.IncomeDao;
import com.itshaala.expensemgrapp.Model.Income;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IncomeService {

    IncomeDao incomeDao;

    public void createIncome(Income income) {
        incomeDao.save(income);
    }

    public List<Income> getAllIncomes() {
        return incomeDao.findAll();
    }

    public Income getIncomesById(int id) {
        return incomeDao.findById(id).get();
    }

    public void deleteIncomeById(int id) {
        incomeDao.deleteById(id);
    }

    public void updateIncome(Income income) {
        Income toBeDeleted = incomeDao.findById(income.getIncomeId()).get();
        incomeDao.delete(toBeDeleted);
        incomeDao.save(income);
    }

    public List<Income> getIncomesByFilter(Income income) {
        return
                incomeDao.findByIncomeNameContainingOrIncomeDescriptionContaining(income.getIncomeName(),income.getIncomeDescription());
    }

}