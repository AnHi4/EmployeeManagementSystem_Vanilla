package ru.study.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
@NonNull
public class ChangeLog {
    private long id;
    private long employeeId;
    private String comment;
    private LocalDate createdAt;
    // private OffsetDateTime
}
