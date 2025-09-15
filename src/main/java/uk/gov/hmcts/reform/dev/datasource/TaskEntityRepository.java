package uk.gov.hmcts.reform.dev.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {
}
