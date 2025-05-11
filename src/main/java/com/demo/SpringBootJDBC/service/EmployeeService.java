package com.demo.SpringBootJDBC.service;

import com.demo.SpringBootJDBC.model.Employee;
import com.demo.SpringBootJDBC.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;
    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }
    public int createEmployee(Employee employee) {
         return repo.save(employee);
    }

    public List<Employee> fetchAll() {
        return repo.findAll();
    }

    public int removeAll() {
        return repo.deleteAll();
    }
}
