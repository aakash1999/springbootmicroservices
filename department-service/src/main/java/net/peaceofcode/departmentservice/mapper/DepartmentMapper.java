package net.peaceofcode.departmentservice.mapper;

import net.peaceofcode.departmentservice.dto.DepartmentDto;
import net.peaceofcode.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper DEPARTMENT_MAPPER = Mappers.getMapper(DepartmentMapper.class);

    Department mapToDepartmentEntity(DepartmentDto departmentDto);

    DepartmentDto mapToDepartmentDto(Department department);

}
