package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
     private EmployeeService employeeService;
    @PostMapping
     public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
     {
         EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
     }


     @GetMapping("{id}")
     public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId)
     {
         EmployeeDto employeedto=employeeService.getEmployeeById( employeeId);
         return ResponseEntity.ok(employeedto);
     }

    @GetMapping
     public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
       List<EmployeeDto> employees= employeeService.getallEmployees();
       return ResponseEntity.ok(employees);
     }
     @PutMapping("{id}")
     public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee)
     {
         EmployeeDto employeedto=employeeService.updateEmployee(employeeId,updatedEmployee);
         return ResponseEntity.ok(employeedto);
     }
    @DeleteMapping("{id}")
     public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
     {
         employeeService.deleteEmployee(employeeId);
         return ResponseEntity.ok("Employee Deleted Successfully");
     }
}
