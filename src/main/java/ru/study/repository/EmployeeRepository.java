package ru.study.repository;

import lombok.NoArgsConstructor;
import ru.study.connection_utils.ConnectionHelper;
import ru.study.model.Employee;
import ru.study.model.param.ChangeEmployeeParam;
import ru.study.model.param.CreateEmployeeParam;
import ru.study.model.param.FireEmployeeParam;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class EmployeeRepository {

    public Long insertEmployee(CreateEmployeeParam createNewEmployeeParam) {
        String insertQuery =
                "INSERT INTO employees (status, first_name, last_name, fathers_name, " +
                        "salary, currency, email, gender, birthday, hire_date) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            prSt.setBoolean(1, true);
            prSt.setString(2, createNewEmployeeParam.getFirstName()); //first_name
            prSt.setString(3, createNewEmployeeParam.getLastName());  //...
            prSt.setString(4, createNewEmployeeParam.getFathersName());
            prSt.setBigDecimal(5, createNewEmployeeParam.getSalary());
            prSt.setString(6, createNewEmployeeParam.getCurrency());
            prSt.setString(7, createNewEmployeeParam.getEmail());
            prSt.setString(8, createNewEmployeeParam.getGender());
            prSt.setDate(9, Date.valueOf(createNewEmployeeParam.getBirthday()));
            prSt.setDate(10, Date.valueOf(createNewEmployeeParam.getHireDate()));
            prSt.executeUpdate();

            ResultSet generatedId = prSt.getGeneratedKeys();
            if (generatedId.next()) {
                return generatedId.getLong(1);
            } else {
                throw new SQLException("Creating ChangeLog failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> selectEmployees() {
        List<Employee> employeeList = new LinkedList<>();
        String selectAllQuery = "SELECT * FROM employees";

        try (Connection conn = ConnectionHelper.createConnection();
             Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(selectAllQuery);
            while (rs.next()) {
                long employee_id = rs.getLong("id");
                boolean isActive = rs.getBoolean("status");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String fathersName = rs.getString("fathers_name");
                BigDecimal salary = rs.getBigDecimal("salary");
                String currency = rs.getString("currency");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                LocalDate hireDate = rs.getDate("hire_date").toLocalDate();
                LocalDate fireDate;
                if (rs.getDate("fire_date") == null) {
                    fireDate = null;
                } else {
                    fireDate = rs.getDate("fire_date").toLocalDate();
                }
                Employee employee = Employee.builder()
                        .id(employee_id)
                        .active(isActive)
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
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    public Employee selectEmployeeById(long id) {
        String selectEmployeeByIdQuery = "SELECT * FROM employees " +
                "Where id = ?";
        Employee employee = Employee.builder().build();

        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(selectEmployeeByIdQuery)) {

            prSt.setLong(1, id);
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                id = rs.getLong("id");
                boolean isActive = rs.getBoolean("status");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String fathersName = rs.getString("fathers_name");
                BigDecimal salary = rs.getBigDecimal("salary");
                String currency = rs.getString("currency");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                LocalDate hireDate = rs.getDate("hire_date").toLocalDate();
                LocalDate fireDate;
                if (rs.getDate("fire_date") == null) {
                    fireDate = null;
                } else {
                    fireDate = rs.getDate("fire_date").toLocalDate();
                }
                employee = Employee.builder()
                        .id(id)
                        .active(isActive)
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    public Employee selectEmployeeByEmail(String email) {
        String selectEmployeeByEmailQuery = "SELECT * FROM employees " +
                "Where email = ?";
        Employee employee = Employee.builder().build();

        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(selectEmployeeByEmailQuery)) {

            prSt.setString(1, email);
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                boolean isActive = rs.getBoolean("status");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String fathersName = rs.getString("fathers_name");
                BigDecimal salary = rs.getBigDecimal("salary");
                String currency = rs.getString("currency");
                email = rs.getString("email");
                String gender = rs.getString("gender");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                LocalDate hireDate = rs.getDate("hire_date").toLocalDate();
                LocalDate fireDate;
                if (rs.getDate("fire_date") == null) {
                    fireDate = null;
                } else {
                    fireDate = rs.getDate("fire_date").toLocalDate();
                }
                employee = Employee.builder()
                        .id(id)
                        .active(isActive)
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    public Long selectEmployeeId(String email) {
        long queriedId = 0;
        String selectEmployeeByEmailQuery = "SELECT * FROM employees " +
                "Where email = ?";

        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(selectEmployeeByEmailQuery)) {
            prSt.setString(1, email);
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                queriedId = rs.getLong("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return queriedId;
    }

    public void updateEmployeeSalary(ChangeEmployeeParam employeeSalaryParam) {
        String updateSalaryQuery = "UPDATE employees " +
                "SET salary = ?, currency = ? " +
                "WHERE id = ?";
        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(updateSalaryQuery)) {
            prSt.setBigDecimal(1, employeeSalaryParam.getNewSalary());
            prSt.setString(2, employeeSalaryParam.getCurrency());
            prSt.setLong(3, employeeSalaryParam.getEmployee_id());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void updateEmployeeStatus(FireEmployeeParam fireEmployeeParam) {
        String updateActiveQuery = "UPDATE employees " +
                "SET active = false" +
                "WHERE id = ?";
        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(updateActiveQuery)) {
            prSt.setLong(1, fireEmployeeParam.getEmployee_id());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}