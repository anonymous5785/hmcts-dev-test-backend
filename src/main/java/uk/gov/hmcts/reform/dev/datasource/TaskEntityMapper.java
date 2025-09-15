package uk.gov.hmcts.reform.dev.datasource;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.reform.dev.domain.Task;

@Component
public class TaskEntityMapper {

    public Task from(TaskEntity task) {
        return Task.builder()
            .id(task.getId())
            .title(task.getTitle())
            .status(task.getStatus())
            .description(task.getDescription())
            .dueDate(task.getDueDate())
            .build();
    }

    public TaskEntity from(Task task) {
        return TaskEntity.builder()
            .id(task.getId())
            .title(task.getTitle())
            .status(task.getStatus())
            .description(task.getDescription())
            .dueDate(task.getDueDate())
            .build();
    }
}
