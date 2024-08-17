package Bezos.TaskManager.Repositories;

import Bezos.TaskManager.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Task, Long> {
}