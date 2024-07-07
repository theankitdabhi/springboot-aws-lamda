package org.example.service;

import org.example.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    // Create a new employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Retrieve all courses
    public List<Employee> getAllEmployee() {
        return employees;
    }

    // Retrieve a employee by id
    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    // Update a employee
    public boolean updateEmployee(int id, Employee newEmployee) {
        return getEmployeeById(id).map(existingEmployee -> {
            employees.remove(existingEmployee);
            employees.add(newEmployee);
            return true;
        }).orElse(false);
    }

    // Delete a employee by id
    public boolean deleteEmployee(int id) {
        return employees
                .removeIf(employee -> employee.getId() == id);
    }
}