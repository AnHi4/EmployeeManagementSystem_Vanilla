package ru.study;

import ru.study.controller.EmployeeManagementController;
import ru.study.model.param.ChangeEmployeeParam;
import ru.study.model.param.CreateEmployeeParam;
import ru.study.repository.EmployeeRepository;
import ru.study.service.EmployeeService;
import ru.study.trash.Utils;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        final EmployeeManagementController employeeManagementController = new EmployeeManagementController();

        CreateEmployeeParam employeeBob = new CreateEmployeeParam("Bob", "Fetcher", "Johnson", "Male",
                "e4@mail", BigDecimal.valueOf(1000), "EUR", LocalDate.of(1990, 6, 13), LocalDate.now());
        CreateEmployeeParam employeeJohn = new CreateEmployeeParam("John", "Doe", "Smith", "Male",
                "e2@mail", BigDecimal.valueOf(12500), "USD", LocalDate.of(1992, 9, 22), LocalDate.now());
        CreateEmployeeParam employeeLena = new CreateEmployeeParam("lena", "Poleno", "xzkto", "Female",
                "e3@mail", BigDecimal.valueOf(20000), "RUB", LocalDate.of(1999, 4, 2), LocalDate.now());

//        employeeManagementController.createEmployee(employeeBob);
//        employeeManagementController.createEmployee(employeeJohn);
//        employeeManagementController.createEmployee(employeeLena);
//
//        System.out.println(employeeManagementController.getEmployees());
        System.out.println(employeeManagementController.getChangeLogs());
        System.out.println(employeeManagementController.getChangeLogsByEmail("e2@mail"));
//        System.out.println();
//
//        ChangeEmployeeParam employeeSalaryParam = new ChangeEmployeeParam(54, BigDecimal.valueOf(2000), "USD", "good worker");
//
//        employeeManagementController.editEmployeeSalary(employeeSalaryParam);
//        System.out.println(employeeManagementController.getChangeLogs());
        System.out.println(employeeManagementController.getChangeLogsById(54));
//
//        System.out.println(employeeManagementController.findEmployeeById(58));
//        System.out.println(employeeManagementController.findEmployeeByEmail("e1@mail"));
    }
}