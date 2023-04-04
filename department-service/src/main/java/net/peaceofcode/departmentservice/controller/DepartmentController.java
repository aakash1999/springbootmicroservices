package net.peaceofcode.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.peaceofcode.departmentservice.dto.DepartmentDto;
import net.peaceofcode.departmentservice.service.DepartmentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String deparmentCode){
        DepartmentDto departmentByCode = departmentService.getDepartmentByCode(deparmentCode);

        return new ResponseEntity<>(departmentByCode, HttpStatus.OK);
    }

}
