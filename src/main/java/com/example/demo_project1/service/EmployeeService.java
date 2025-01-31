package com.example.demo_project1.service;

import com.example.demo_project1.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  interface EmployeeService {
    List<Employee> gelAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

