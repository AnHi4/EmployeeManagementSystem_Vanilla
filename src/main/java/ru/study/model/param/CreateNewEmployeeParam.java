package ru.study.model.param;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NonNull

//@Builder??
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
