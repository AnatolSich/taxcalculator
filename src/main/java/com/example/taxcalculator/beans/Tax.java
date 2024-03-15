package com.example.taxcalculator.beans;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Setter
@Getter
public class Tax {

    @Id
    private int id;
    private String name;
    private Double lower_annual_salary_limit;
    private Double upper_annual_salary_limit;
    private Double tax_rate;
}
