package uk.gov.hmcts.reform.dev.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.hmcts.reform.dev.domain.Task;
import uk.gov.hmcts.reform.dev.domain.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DatasourceTaskRepository implements TaskRepository {

    @Autowired
    TaskEntityRepository taskEntityRepository;

    @Autowired
    TaskEntityMapper taskEntityMapper;

    @Override
    public Optional<Task> getTask(long id) {
        return taskEntityRepository.findById(id)
            .map(taskEntityMapper::from);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskEntityRepository.findAll()
            .stream().map(taskEntityMapper::from)
            .collect(Collectors.toList());
    }

    @Override
    public Task saveTask(Task task) {
        TaskEntity taskEntity = taskEntityMapper.from(task);
        return taskEntityMapper.from(taskEntityRepository.save(taskEntity));
    }

    @Override
    public void deleteTask(long id) {
        taskEntityRepository.deleteById(id);
    }
}
