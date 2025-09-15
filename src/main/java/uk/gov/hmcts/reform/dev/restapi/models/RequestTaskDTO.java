package uk.gov.hmcts.reform.dev.restapi.models;


import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestTaskDTO {

    private String title;
    private String description;
    private String status;
    private Instant dueDate;
}
