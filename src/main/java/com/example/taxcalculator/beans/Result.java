package com.example.taxcalculator.beans;

import lombok.Data;

@Data
public class Result {

    private Double grossAnnualSalary;
    private Double grossMonthlySalary;
    private Double netAnnualSalary;
    private Double netMonthlySalary;
    private Double annualTaxPaid;
    private Double monthlyTaxPaid;
}
