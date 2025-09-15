package uk.gov.hmcts.reform.dev.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    TaskRepository taskRepository;

    TaskService target;

    @BeforeEach
    public void init() {
        target = new TaskService(taskRepository);
    }

    @Test
    public void getAllTasks_callsTaskRepository_returnsListObtained() {
        List<Task> expected = new ArrayList<>();
        when(taskRepository.getAllTasks()).thenReturn(expected);

        assertEquals(expected, target.getAllTasks());
    }

    @Test
    public void getTask_callsTaskRepository_returnsTaskObtained() {
        long id = 3;
        Optional<Task> expected = Optional.of(new Task.TaskBuilder().build());
        when(taskRepository.getTask(id)).thenReturn(expected);

        assertEquals(expected, target.getTask(id));
    }

    @Test
    public void deleteTask_callsTaskRepository() {
        long id = 3;

        target.deleteTask(id);

        verify(taskRepository, times(1)).deleteTask(id);
    }

    @Test
    public void saveTask_callsTaskRepository_returnsSavedTask() {
        Task newTask = new Task.TaskBuilder().build();
        Task taskSaved = new Task.TaskBuilder().build();
        when(taskRepository.saveTask(newTask)).thenReturn(taskSaved);

        assertEquals(taskSaved, target.saveTask(newTask));
    }
}
