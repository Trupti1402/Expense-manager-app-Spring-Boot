package com.itshaala.expensemgrapp.Dao;

import com.itshaala.expensemgrapp.Model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeDao extends JpaRepository<Income, Long> {

    List<Income> findByIncomeNameContainingOrIncomeDescriptionContaining(String incomeName, String incomeDescription);

}