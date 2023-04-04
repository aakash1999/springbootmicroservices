package net.peaceofcode.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.peaceofcode.departmentservice.dto.DepartmentDto;
import net.peaceofcode.departmentservice.entity.Department;
import net.peaceofcode.departmentservice.exception.ResourceNotFoundException;
import net.peaceofcode.departmentservice.mapper.DepartmentMapper;
import net.peaceofcode.departmentservice.repository.DepartmentRepository;
import net.peaceofcode.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code).orElseThrow(()->{
            return new ResourceNotFoundException("Department with code : " + code + " Not Found");
        });
        DepartmentDto departmentDto = DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
