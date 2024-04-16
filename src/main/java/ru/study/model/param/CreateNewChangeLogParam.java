package ru.study.model.param;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NonNull
//@Builder ??

public class CreateNewChangeLogParam {
    private long employeeId;
    private String comment;
    private LocalDate createdAt;
}
