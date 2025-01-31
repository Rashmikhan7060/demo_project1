package com.example.demo_project1.service;

import com.example.demo_project1.model.Employee;
import com.example.demo_project1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public  class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;


    @Override
    public List<Employee> gelAllEmployees() {
        return employeeRepository.findAll();


    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }


    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = employeeRepository.getById(id);
        return employee;

        //        Optional<Employee> optional = employeeRepository.findById(id);
//         Employee employee = null;
//         if(optional.isPresent()){
//             employee = optional.get();
//         } else{
//             throw new RuntimeException("Employee not found for id: " +id );
//         }
//            return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
      this. employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize,String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();


        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
        return this.employeeRepository.findAll(pageable);
    }
}