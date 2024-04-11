package ru.study.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@ToString
public class Employee {
    @NonNull
    private long id;
    @NonNull
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
    @NonNull
    private String gender;
    @NonNull
    private LocalDate birthday;
    @NonNull
    private LocalDate hireDate;
    private LocalDate fireDate;
}
