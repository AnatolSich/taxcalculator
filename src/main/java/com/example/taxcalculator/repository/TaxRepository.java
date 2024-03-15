package com.example.taxcalculator.repository;

import com.example.taxcalculator.beans.Tax;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRepository extends CrudRepository<Tax, Integer> {

    @Query("select t from Tax t where t.lower_annual_salary_limit <= :salary")
    public List<Tax> searchByLowerAnnualSalaryLimit(@Param("salary") Double salary);

    @Query("select t from Tax t")
    public List<Tax> findAll(Sort sort);
}
