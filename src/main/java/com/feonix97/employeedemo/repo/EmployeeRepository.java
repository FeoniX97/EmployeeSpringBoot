package com.feonix97.employeedemo.repo;

import com.feonix97.employeedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// use custom endpoint "members" instead of default entity name(s)
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
