package com.feonix97.employeedemo.rest;

import com.feonix97.employeedemo.entity.Employee;
import com.feonix97.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable(name = "employeeId") int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee oldEmployee = employeeService.findById(employee.getId());

        if (oldEmployee == null) {
            throw new RuntimeException("Employee not found with id - " + employee.getId());
        }

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with id - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
