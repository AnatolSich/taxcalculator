package com.example.taxcalculator.controllers;

import com.example.taxcalculator.beans.Result;
import com.example.taxcalculator.beans.Tax;
import com.example.taxcalculator.repository.TaxRepository;
import com.example.taxcalculator.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaxController {

    @Autowired
    private TaxRepository taxRepository;

    @Autowired
    private TaxService taxService;

    @GetMapping("/tax")
    public String search(@RequestParam("salary") Double salary, Model model){
        System.out.println("in salary controller");
        System.out.println("salary: " + salary);

        List<Tax> taxes = taxRepository.findAll(Sort.by("name"));
        System.out.println("taxes = " + taxes.size());
        List<Result> results = new ArrayList<>();

        List<Tax> filteredTaxes = new ArrayList<>();
        Double tempSalary = salary;
        if (!taxes.isEmpty()) {
            for (int t = 0; t < taxes.size(); t++) {
                Tax tempTax = taxes.get(t);
                if (tempTax.getLower_annual_salary_limit() <= tempSalary){
                    filteredTaxes.add(tempTax);
                    if (tempTax.getUpper_annual_salary_limit() != null){
                    tempSalary = tempSalary - tempTax.getUpper_annual_salary_limit();}
                }
            }
        }

        results.add(taxService.calculate(filteredTaxes, salary));
        model.addAttribute("results", results);
        return "result";
    }
}
