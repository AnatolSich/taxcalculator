package com.example.taxcalculator.services;

import com.example.taxcalculator.beans.Result;
import com.example.taxcalculator.beans.Tax;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxService {

    public Result calculate(List<Tax> taxes, Double salary){
        System.out.println("in TaxService");

        Result result = new Result();
        result.setGrossAnnualSalary(salary);
        Double grossMonthlySalary = salary/12;
        System.out.println("grossMonthlySalary: " + grossMonthlySalary);
        result.setGrossMonthlySalary(grossMonthlySalary);

        Double taxAmount = taxes.stream()
                .map(tax -> salary*(tax.getTax_rate()/100)).mapToDouble(Double::doubleValue).sum();

        System.out.println("taxAmount: " + taxAmount);
        result.setAnnualTaxPaid(taxAmount);
        result.setNetAnnualSalary(salary - taxAmount);
        System.out.println("setNetAnnualSalary: " + result.getNetAnnualSalary());
        Double monthlyTaxPaid = taxAmount/12;
        System.out.println("monthlyTaxPaid: " + monthlyTaxPaid);
        result.setMonthlyTaxPaid(monthlyTaxPaid);
        result.setNetMonthlySalary(grossMonthlySalary - monthlyTaxPaid);
        System.out.println("setNetMonthlySalary: " + result.getNetMonthlySalary());

        return result;
    }


}
