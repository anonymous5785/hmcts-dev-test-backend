package uk.gov.hmcts.reform.dev.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gov.hmcts.reform.dev.domain.Task;
import uk.gov.hmcts.reform.dev.domain.TaskService;
import uk.gov.hmcts.reform.dev.restapi.models.RequestTaskDTOMapper;
import uk.gov.hmcts.reform.dev.restapi.models.RequestTaskDTO;
import uk.gov.hmcts.reform.dev.restapi.models.TaskDTO;
import uk.gov.hmcts.reform.dev.restapi.models.TaskDTOMapper;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    @Autowired
    private TaskDTOMapper taskDTOMapper;

    @Autowired
    private RequestTaskDTOMapper requestTaskDTOMapper;

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<TaskDTO> getTask(@PathVariable("id") Long id) {
        return taskService.getTask(id)
            .map(taskDTOMapper::from)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found for id=" + id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Set<TaskDTO>> getAllTasks() {
        return ok(taskService.getAllTasks().stream().map(task -> taskDTOMapper.from(task)).collect(Collectors.toSet()));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TaskDTO> createTask(@RequestBody RequestTaskDTO requestTaskDTO) {
        return ok(taskDTOMapper.from(
            taskService.saveTask(requestTaskDTOMapper.from(requestTaskDTO))
        ));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable("id") Long id,
                                              @RequestBody RequestTaskDTO requestTaskDTO) {
        Task task = requestTaskDTOMapper.from(requestTaskDTO);
        task.setId(id);
        return ok(taskDTOMapper.from(taskService.saveTask(task)));
    }

}
