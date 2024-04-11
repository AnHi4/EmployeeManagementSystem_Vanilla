package ru.study.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.time.Instant;

@Data
@Builder
@ToString
public class ChangeLog {
    @NonNull
    private long id;
    @NonNull
    private long employeeId;
    @NonNull
    private Instant createdAt;
    @NonNull
    private String comment;
}
