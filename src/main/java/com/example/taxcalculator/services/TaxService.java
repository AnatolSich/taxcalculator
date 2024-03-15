package com.example.taxcalculator.services;

import com.example.taxcalculator.beans.Result;
import com.example.taxcalculator.beans.Tax;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxService {

    public Result calculate(List<Tax> taxes, Double salary){
        System.out.println("in TaxService");
        System.out.println("taxes = " + taxes.size());

        Result result = new Result();
        result.setGrossAnnualSalary(roundTwoDecimals(salary));
        Double grossMonthlySalary = salary/12;
        System.out.println("grossMonthlySalary: " + grossMonthlySalary);
        result.setGrossMonthlySalary(roundTwoDecimals(grossMonthlySalary));

        Double taxAmount = calculateTaxAmount(taxes, salary);

        System.out.println("taxAmount: " + taxAmount);
        result.setAnnualTaxPaid(roundTwoDecimals(taxAmount));
        result.setNetAnnualSalary(roundTwoDecimals(salary - taxAmount));
        System.out.println("setNetAnnualSalary: " + result.getNetAnnualSalary());
        Double monthlyTaxPaid = taxAmount/12;
        System.out.println("monthlyTaxPaid: " + monthlyTaxPaid);
        result.setMonthlyTaxPaid(roundTwoDecimals(monthlyTaxPaid));
        result.setNetMonthlySalary(roundTwoDecimals(grossMonthlySalary - monthlyTaxPaid));
        System.out.println("setNetMonthlySalary: " + result.getNetMonthlySalary());

        return result;
    }

    private static Double calculateTaxAmount(List<Tax> taxes, Double salary) {
        Double taxAmount = 0d;

        Double tempSalary = salary;
        if (!taxes.isEmpty()) {
            for (int t = 0; t < taxes.size(); t++) {
                Tax tempTax = taxes.get(t);
                Double lowerAnnualSalaryLimit = tempTax.getLower_annual_salary_limit();
                Double upperAnnualSalaryLimit = tempTax.getUpper_annual_salary_limit();
                Double taxRate = tempTax.getTax_rate() / 100;
                System.out.println("id = " + tempTax.getId());
                System.out.println("upperAnnualSalaryLimit = " + upperAnnualSalaryLimit);

                if (upperAnnualSalaryLimit == null || upperAnnualSalaryLimit >= tempSalary){
                    taxAmount = taxAmount + tempSalary * taxRate;
                    System.out.println("taxAmount = " + taxAmount);
                    System.out.println("tempSalary = " + tempSalary);
                    return taxAmount;
                } else {
                    taxAmount = taxAmount + (upperAnnualSalaryLimit-lowerAnnualSalaryLimit) * taxRate;
                    tempSalary = tempSalary - (upperAnnualSalaryLimit-lowerAnnualSalaryLimit);
                    System.out.println("taxAmount = " + taxAmount);
                    System.out.println("tempSalary = " + tempSalary);

                }
            }
        }
        return taxAmount;
    }

    private static Double roundTwoDecimal(Double initial){
        DecimalFormat twoDForm = new DecimalFormat("#.00");
        return Double.valueOf(twoDForm.format(initial));
    }
    private static BigDecimal roundTwoDecimals(Double initial){
        BigDecimal a = new BigDecimal(initial);
        return a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }


}
