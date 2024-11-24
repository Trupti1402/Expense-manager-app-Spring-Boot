package com.itshaala.expensemgrapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @Data
    @Entity
    @Table(name = "expense")


public class Expense {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "expense_id")
        private int expenseId;

        @Column(name = "expense_name")
        private String expenseName;

        @Column(name = "expense_amount")
        private double expenseAmount;

        @Column(name = "expense_category")
        private String expenseCategory;

        @Column(name = "expense_description")
        private String expenseDescription;

        @Column(name = "expense_date")
        private LocalDateTime expenseDate;
}
