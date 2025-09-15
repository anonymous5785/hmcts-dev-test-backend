package uk.gov.hmcts.reform.dev.restapi.models;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.reform.dev.domain.Task;

@Component
public class RequestTaskDTOMapper {

    public Task from(RequestTaskDTO task) {
        return Task.builder()
            .title(task.getTitle())
            .status(task.getStatus())
            .description(task.getDescription())
            .dueDate(task.getDueDate())
            .build();
    }
}
