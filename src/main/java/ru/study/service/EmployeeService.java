package ru.study.service;

import ru.study.connection_utils.ConnectionHelper;
import ru.study.model.Employee;
import ru.study.model.param.CreateNewEmployeeParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class EmployeeService {
    public static void createNewEmployee(CreateNewEmployeeParam createNewEmployeeParam){
        String insQuery =
                "INSERT INTO employee (status, firstName, lastName, fathersName, " +
                        "salary, currency, email, gender, birthday, hireDate) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement prSt = ConnectionHelper.createConnection().prepareStatement(insQuery)) {
            prSt.setBoolean(1, true);
            prSt.setString(2, createNewEmployeeParam.getFirstName());
            prSt.setString(3, createNewEmployeeParam.getLastName());
            prSt.setString(4, createNewEmployeeParam.getFathersName());
            prSt.setBigDecimal(5, createNewEmployeeParam.getSalary());
            prSt.setString(6, createNewEmployeeParam.getCurrency());
            prSt.setString(7, createNewEmployeeParam.getEmail());
            prSt.setString(8, createNewEmployeeParam.getGender());
            prSt.setDate(9, Date.valueOf(createNewEmployeeParam.getBirthday()));
            prSt.setDate(10, Date.valueOf(createNewEmployeeParam.getHireDate()));

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> getEmployeeDB(){

        List<Employee> employeeList = new LinkedList<>();
        String selectAllQuery = "SELECT * FROM employee";

        try (
                PreparedStatement prSt = ConnectionHelper.createConnection().prepareStatement(selectAllQuery);
                ResultSet rs = prSt.executeQuery()
        )
        {
            while (rs.next()) {
                long employee_id = rs.getLong("employee_id");
                boolean isActive = rs.getBoolean("status");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String fathersName = rs.getString("fathersName");
                BigDecimal salary = rs.getBigDecimal("salary");
                String currency = rs.getString("currency");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                LocalDate hireDate = rs.getDate("hireDate").toLocalDate();
                LocalDate fireDate;
                if (rs.getDate("fireDate") == null){
                    fireDate = null;
                } else {
                    fireDate = rs.getDate("fireDate").toLocalDate();
                }
                Employee tempEmployee = Employee.builder()
                        .id(employee_id)
                        .isActive(isActive)
                        .firstName(firstName)
                        .lastName(lastName)
                        .fathersName(fathersName)
                        .salary(salary)
                        .currency(currency)
                        .email(email)
                        .gender(gender)
                        .birthday(birthday)
                        .hireDate(hireDate)
                        .fireDate(fireDate)
                        .build();
                employeeList.add(tempEmployee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}
