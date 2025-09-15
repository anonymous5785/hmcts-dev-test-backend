package uk.gov.hmcts.reform.dev.restapi.models;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.reform.dev.domain.Task;

@Component
public class TaskDTOMapper {

    public TaskDTO from(Task task) {
        return TaskDTO.builder()
            .id(task.getId())
            .title(task.getTitle())
            .status(task.getStatus())
            .description(task.getDescription())
            .dueDate(task.getDueDate())
            .build();
    }
}
