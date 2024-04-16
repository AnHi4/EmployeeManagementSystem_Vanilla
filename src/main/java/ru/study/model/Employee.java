package ru.study.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NonNull
public class Employee {

    private long employee_id;

    private boolean isActive;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String fathersName;
    @NonNull
    private BigDecimal salary;
    @NonNull
    private String currency;
    @NonNull
    private String email;
    //получить пиздюлей за ноннуллы
    //ноннулы нужны, потому что какой смысл хранить полупустые поля в бд про сотрудников - в этом ведь нет смысла
    //however...
    @NonNull
    private String gender;
    @NonNull
    private LocalDate birthday;
    @NonNull
    private LocalDate hireDate;
    private LocalDate fireDate;
}
