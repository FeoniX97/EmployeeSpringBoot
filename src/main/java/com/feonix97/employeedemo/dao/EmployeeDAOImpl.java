package com.feonix97.employeedemo.dao;

import com.feonix97.employeedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * obsolete, use Spring Data JPA instead
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    // define field for entity manager
    private final EntityManager entityManager;

    // set up constructor injector
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // return the results
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        // return employee
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }
}
