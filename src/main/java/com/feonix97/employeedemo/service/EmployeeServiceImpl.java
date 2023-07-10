package com.feonix97.employeedemo.service;

import com.feonix97.employeedemo.entity.Employee;
import com.feonix97.employeedemo.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    /**
     * obsolete, use Spring Data JPA instead
     */
    // private final EmployeeDAO employeeDAO;

//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        return result.orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
