package ru.study.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NonNull
public class Employee {

    //enjoyers
    private long id;
    private boolean active;
    private String firstName;
    private String lastName;
    private String fathersName;

    //GIGACHADS
    private BigDecimal salary;
    private String currency;

    //enjoyers
    private String email;
    private String gender;
    private LocalDate birthday;
    private LocalDate hireDate;
    private LocalDate fireDate;
}
