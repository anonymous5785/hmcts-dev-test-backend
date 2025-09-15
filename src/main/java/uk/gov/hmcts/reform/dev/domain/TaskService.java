package uk.gov.hmcts.reform.dev.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.getTask(id);
    }

    public Collection<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }
    public Task saveTask(Task task) {
        return taskRepository.saveTask(task);
    }

    public void deleteTask(long id) {
        taskRepository.deleteTask(id);
    }
}
