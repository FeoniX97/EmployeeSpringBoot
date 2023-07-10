package com.feonix97.employeedemo.dao;

import com.feonix97.employeedemo.entity.Employee;

import java.util.List;

/**
 * obsolete, use Spring Data JPA instead
 */
public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
