package ru.study.model.param;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateChangeLogParam {
    private long employeeId;
    private String comment;
    private LocalDate createdAt;
}
