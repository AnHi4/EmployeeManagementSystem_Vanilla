package ru.study.model.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class CreateNewEmployeeParam {
        private String firstName;
        private String lastName;
        private String fathersName;
        private String gender;
        private String email;
        private BigDecimal salary;
        private String currency;
        private LocalDate birthday;
        private LocalDate hireDate;
}
