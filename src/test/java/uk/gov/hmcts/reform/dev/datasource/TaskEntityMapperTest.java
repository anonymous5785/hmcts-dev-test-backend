package uk.gov.hmcts.reform.dev.datasource;

import org.junit.jupiter.api.Test;
import uk.gov.hmcts.reform.dev.domain.Task;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskEntityMapperTest {

    private static final long ID = 5;
    private static final Instant DUE_DATE = Instant.now();
    private static final String TITLE = "Important task";
    private static final String STATUS = "In progress";
    private static final String DESCRIPTION = "something important";

    @Test
    public void mapFromEntity() {

        TaskEntity entity = TaskEntity.builder()
            .id(ID)
            .title(TITLE)
            .status(STATUS)
            .description(DESCRIPTION)
            .dueDate(DUE_DATE)
            .build();

        Task result = new TaskEntityMapper().from(entity);

        assertEquals(ID, result.getId());
        assertEquals(TITLE, result.getTitle());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(STATUS, result.getStatus());
        assertEquals(DUE_DATE, result.getDueDate());
    }

    @Test
    public void mapFromDomain() {

        Task task = Task.builder()
            .id(ID)
            .title(TITLE)
            .status(STATUS)
            .description(DESCRIPTION)
            .dueDate(DUE_DATE)
            .build();

        TaskEntity result = new TaskEntityMapper().from(task);

        assertEquals(ID, result.getId());
        assertEquals(TITLE, result.getTitle());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(STATUS, result.getStatus());
        assertEquals(DUE_DATE, result.getDueDate());
    }
}
