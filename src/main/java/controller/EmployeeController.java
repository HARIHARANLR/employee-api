package org.example.employeeaoi.controller;

import org.example.employeeaoi.entity.Employee;
import org.example.employeeaoi.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    // GET ALL
    @GetMapping
    public List<Employee> getAll() {
        log.info("Fetching all employees");
        return repo.findAll();
    }

    // CREATE
    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        log.info("Creating employee: {}", emp.getName());
        return repo.save(emp);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        log.info("Fetching employee with id: {}", id);
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        log.info("Updating employee with id: {}", id);
        Employee existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setDepartment(emp.getDepartment());
        existing.setSalary(emp.getSalary());

        return repo.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting employee with id: {}", id);
        repo.deleteById(id);
    }
}
