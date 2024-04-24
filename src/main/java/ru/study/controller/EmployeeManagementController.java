package ru.study.controller;

import ru.study.model.ChangeLog;
import ru.study.model.Employee;
import ru.study.model.param.ChangeEmployeeParam;
import ru.study.model.param.CreateEmployeeParam;
import ru.study.model.param.FireEmployeeParam;
import ru.study.service.ChangeLogService;
import ru.study.service.EmployeeService;

import java.util.List;


public class EmployeeManagementController {

    private final EmployeeService employeeService;
    private final ChangeLogService changeLogService;

    public EmployeeManagementController() {
        employeeService = new EmployeeService();
        changeLogService = new ChangeLogService();
    }

    public void createEmployee(CreateEmployeeParam createEmployeeParam) {
        employeeService.createEmployee(createEmployeeParam);
    }

    // добавить фильтрацию email
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    public Employee findEmployeeById(long id) {
        return employeeService.findEmployeeById(id);
    }
    public Employee findEmployeeByEmail(String email) {
        return employeeService.findEmployeeByEmail(email);
    }


    // добавить фильтрацию employee_id

    public List<ChangeLog> getChangeLogs() {
        return changeLogService.getChangeLogs();
    }

    public List<ChangeLog> getChangeLogsById(long id){
        return changeLogService.getChangeLogsById(id);
    }

    //переиспользовать используемые методы или удалить

    public List<ChangeLog> getChangeLogsByEmail(String email) {
        return changeLogService.getChangeLogsById(employeeService.getEmployeeId(email));
    }

    public void editEmployeeSalary(ChangeEmployeeParam employeeSalaryParam) {
        employeeService.editEmployeeSalary(employeeSalaryParam);
    }

    public void fireEmployee(FireEmployeeParam fireEmployeeParam) {
        employeeService.editEmployeeStatus(fireEmployeeParam);
    }
}
