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

        List<Tax> taxes = taxRepository.findAll(Sort.by("name"));
        List<Result> results = new ArrayList<>();

        results.add(taxService.calculate(taxes, salary));
        model.addAttribute("results", results);
        return "result";
    }
}
