package ru.study;

import ru.study.controller.EmployeeManagementController;
import ru.study.model.param.CreateNewEmployeeParam;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final EmployeeManagementController employeeManagementController = new EmployeeManagementController();

        CreateNewEmployeeParam employeeBob = new CreateNewEmployeeParam("Bob", "Fetcher", "Johnson", "Male",
                "e@mail", BigDecimal.valueOf(1000), "EUR", LocalDate.of(1990, 6, 13), LocalDate.now());
        CreateNewEmployeeParam employeeJohn = new CreateNewEmployeeParam("John", "Doe", "Smith", "Male",
                "e@mail", BigDecimal.valueOf(12500), "USD", LocalDate.of(1992, 9, 22), LocalDate.now());
        CreateNewEmployeeParam employeeLena = new CreateNewEmployeeParam("lena", "Poleno", "xzkto", "Female",
                "e@mail", BigDecimal.valueOf(20000), "RUB", LocalDate.of(1999, 4, 2), LocalDate.now());

        //employeeManagementController.createNewEmployee(employeeBob);
        //employeeManagementController.createNewEmployee(employeeJohn);
        //employeeManagementController.createNewEmployee(employeeLena);
        System.out.println(employeeManagementController.findAllChangeLogs());
        System.out.println(employeeManagementController.findAllEmployees());
    }
}