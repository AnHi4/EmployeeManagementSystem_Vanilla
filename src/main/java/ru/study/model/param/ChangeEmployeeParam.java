package ru.study.model.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
public class ChangeEmployeeParam {
    long employee_id;
    BigDecimal newSalary;
    String currency;
    String comment;
}
