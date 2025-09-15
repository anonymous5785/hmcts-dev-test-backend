package uk.gov.hmcts.reform.dev.datasource;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, length = 100)
    private String status;

    @Column(name = "due_date", nullable = false)
    private Instant dueDate;

}
