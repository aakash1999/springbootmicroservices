package net.peaceofcode.departmentservice.repository;

import net.peaceofcode.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
