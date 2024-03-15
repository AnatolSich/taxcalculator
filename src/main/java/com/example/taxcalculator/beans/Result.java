package com.example.taxcalculator.beans;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Result {

    private BigDecimal grossAnnualSalary;
    private BigDecimal grossMonthlySalary;
    private BigDecimal netAnnualSalary;
    private BigDecimal netMonthlySalary;
    private BigDecimal annualTaxPaid;
    private BigDecimal monthlyTaxPaid;
}
