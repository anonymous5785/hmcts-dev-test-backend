package uk.gov.hmcts.reform.dev.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class Task {

    private long id;

    private String title;

    private String description;

    private String status;

    private Instant dueDate;
}
