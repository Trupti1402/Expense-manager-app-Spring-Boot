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
@Table(name = "income")


public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "income_id")
    private int incomeId;

    @Column(name = "income_name")
    private String incomeName;

    @Column(name = "income_amount")
    private double incomeAmount;

    @Column(name = "income_category")
    private String incomeCategory;

    @Column(name = "income_description")
    private String incomeDescription;

    @Column(name = "income_date")
    private LocalDateTime incomeDate;
}