package uk.gov.hmcts.reform.dev.domain;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> getTask(long id);

    List<Task> getAllTasks();

    Task saveTask(Task task);

    void deleteTask(long id);
}
