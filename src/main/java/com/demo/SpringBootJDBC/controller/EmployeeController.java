package com.demo.SpringBootJDBC.controller;

import com.demo.SpringBootJDBC.model.Employee;
import com.demo.SpringBootJDBC.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
         int rows = service.createEmployee(employee);
         if(rows !=0) {
             return "Added";
         }
         return null;
    }

    @GetMapping("/all")
    public ResponseEntity<?> fetchAll() {
        List<Employee> employees = service.fetchAll();
        if(employees.isEmpty()) {
            return ResponseEntity.ok("Table is Empty");
        } else {
            return ResponseEntity.ok(employees);
        }
    }

    @DeleteMapping("/deleteAll")
    public String deleteEmp() {
        int rowDeleted = service.removeAll();
        if(rowDeleted!=0) {
            return "All data deleted";
        } else {
            return "Table is already empty";
        }
    }
}
