package net.peaceofcode.departmentservice.service;

import net.peaceofcode.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
