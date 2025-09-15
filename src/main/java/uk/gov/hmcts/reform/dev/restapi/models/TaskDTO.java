package uk.gov.hmcts.reform.dev.restapi.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskDTO {

    private long id;
    private String title;
    private String description;
    private String status;
    private Instant dueDate;
}
