package ru.study.service;

import ru.study.model.Employee;
import ru.study.model.param.ChangeEmployeeParam;
import ru.study.model.param.CreateChangeLogParam;
import ru.study.model.param.CreateEmployeeParam;
import ru.study.model.param.FireEmployeeParam;
import ru.study.repository.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ChangeLogService changeLogService;

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
        changeLogService = new ChangeLogService();
    }

    public void createEmployee(CreateEmployeeParam createEmployeeParam) {
        final long employeeId = employeeRepository.insertEmployee(createEmployeeParam);
        final CreateChangeLogParam createChangeLogParam = new CreateChangeLogParam(employeeId,
                "hired at",
                createEmployeeParam.getHireDate());
        changeLogService.createChangeLog(createChangeLogParam);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.selectEmployees();
    }

    public Employee findEmployeeById(long id) {
        return employeeRepository.selectEmployeeById(id);
    }
    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.selectEmployeeByEmail(email);
    }
    public Long getEmployeeId(String email) {
        return employeeRepository.selectEmployeeId(email);
    }

    public void editEmployeeSalary(ChangeEmployeeParam employeeSalaryParam) {
        employeeRepository.updateEmployeeSalary(employeeSalaryParam);
        CreateChangeLogParam createChangeLogParam = new CreateChangeLogParam(
                employeeSalaryParam.getEmployee_id(),
                employeeSalaryParam.getComment(),
                LocalDate.now());
        changeLogService.createChangeLog(createChangeLogParam);
    }

    public void editEmployeeStatus(FireEmployeeParam fireEmployeeParam) {
        employeeRepository.updateEmployeeStatus(fireEmployeeParam);
        CreateChangeLogParam createChangeLogParam = new CreateChangeLogParam(
                fireEmployeeParam.getEmployee_id(),
                fireEmployeeParam.getComment(),
                LocalDate.now());
                changeLogService.createChangeLog(createChangeLogParam);
    }
}