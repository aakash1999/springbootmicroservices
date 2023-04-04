package net.peaceofcode.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.peaceofcode.employeeservice.dto.EmployeeDto;
import net.peaceofcode.employeeservice.entity.Employee;
import net.peaceofcode.employeeservice.exception.ResourceNotFoundException;
import net.peaceofcode.employeeservice.mapper.EmployeeMapper;
import net.peaceofcode.employeeservice.repository.EmployeeRepository;
import net.peaceofcode.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.EMPLOYEE_MAPPER.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.orElseThrow(()->new ResourceNotFoundException("Employee with id : "
                + employeeId + " Not Found"));
        return EmployeeMapper.EMPLOYEE_MAPPER.maptoEmployeeDto(employee);
    }
}
