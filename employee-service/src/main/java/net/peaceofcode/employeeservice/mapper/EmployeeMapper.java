package net.peaceofcode.employeeservice.mapper;

import net.peaceofcode.employeeservice.dto.EmployeeDto;
import net.peaceofcode.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto maptoEmployeeDto(Employee employee);

    Employee mapToEmployeeEntity(EmployeeDto employeeDto);

}
