package com.sudheesh.cruddemo.dao;

import com.sudheesh.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
}
