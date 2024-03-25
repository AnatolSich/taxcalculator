package com.example.taxcalculator.services;

import com.example.taxcalculator.beans.Result;
import com.example.taxcalculator.beans.Tax;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class TaxService {

    public Result calculate(List<Tax> taxes, Double salary){
        Result result = new Result();
        result.setGrossAnnualSalary(roundTwoDecimals(salary));
        Double grossMonthlySalary = salary/12;
        result.setGrossMonthlySalary(roundTwoDecimals(grossMonthlySalary));

        Double taxAmount = calculateTaxAmount(taxes, salary);

        result.setAnnualTaxPaid(roundTwoDecimals(taxAmount));
        result.setNetAnnualSalary(roundTwoDecimals(salary - taxAmount));
        Double monthlyTaxPaid = taxAmount/12;
        result.setMonthlyTaxPaid(roundTwoDecimals(monthlyTaxPaid));
        result.setNetMonthlySalary(roundTwoDecimals(grossMonthlySalary - monthlyTaxPaid));

        return result;
    }

    private static Double calculateTaxAmount(List<Tax> taxes, Double salary) {
        double taxAmount = 0d;

        Double tempSalary = salary;
        if (!taxes.isEmpty()) {
            for (Tax tempTax : taxes) {
                Double lowerAnnualSalaryLimit = tempTax.getLower_annual_salary_limit();
                Double upperAnnualSalaryLimit = tempTax.getUpper_annual_salary_limit();
                Double taxRate = tempTax.getTax_rate() / 100;

                if (upperAnnualSalaryLimit == null || upperAnnualSalaryLimit >= tempSalary) {
                    taxAmount = taxAmount + tempSalary * taxRate;
                    return taxAmount;
                } else {
                    taxAmount = taxAmount + (upperAnnualSalaryLimit - lowerAnnualSalaryLimit) * taxRate;
                    tempSalary = tempSalary - (upperAnnualSalaryLimit - lowerAnnualSalaryLimit);
                }
            }
        }
        return taxAmount;
    }

    private static BigDecimal roundTwoDecimals(Double initial){
        BigDecimal a = new BigDecimal(initial);
        return a.setScale(2, RoundingMode.HALF_EVEN);
    }


}
