package net.peaceofcode.employeeservice.repository;

import net.peaceofcode.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
