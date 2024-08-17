package Bezos.TaskManager.Models;

import Bezos.TaskManager.enums.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 225)
    private String description;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column( nullable = false)
    private LocalTime creationTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private TaskStatus status;

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", creationTime=" + creationTime +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Task(Long id, String title, String description, LocalDate creationDate, LocalTime creationTime, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
        this.status = status;
    }
}
