package ru.study.controller;

import ru.study.model.Employee;
import ru.study.model.param.CreateNewEmployeeParam;
import ru.study.service.ChangeLogService;
import ru.study.service.EmployeeService;

import java.util.List;

public class EmployeeManagementController {

    public void createNewEmployee(CreateNewEmployeeParam createNewEmployeeParam) {
        EmployeeService.createNewEmployee(createNewEmployeeParam);
    }

    public List<Employee> findAllEmployees(){
        return EmployeeService.getEmployeeDB();
    }
}
