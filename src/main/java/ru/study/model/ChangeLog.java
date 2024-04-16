package ru.study.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NonNull
public class ChangeLog {
    private long changeLog_id;
    private long employee_id;
    private String comment;
    private LocalDate createdAt;

}
