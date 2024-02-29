package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.exception.ResourceNotFound;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getallEmployees();

    EmployeeDto updateEmployee(Long empleeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long emplyeeId);



}
