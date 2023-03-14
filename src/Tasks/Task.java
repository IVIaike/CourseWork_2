package Tasks;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private String title;
    private String description;
    private TaskType taskType;
    private LocalDateTime deadLine;
    private boolean isFinished;

    private final long id = count;
    private static long count = 1L;

    public Task(String title, String description, TaskType taskType, LocalDateTime localDateTime) throws WrongInputExceptions {
        this.title = ValidationUtils.validateString(title);
        this.description = ValidationUtils.validateString(description);
        this.taskType = taskType;
        this.deadLine = localDateTime;
        this.isFinished = false;
        count++;
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

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getId() == task.getId() && getTitle().equals(task.getTitle()) && getDescription().equals(task.getDescription()) && getTaskType() == task.getTaskType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getTaskType(), getId());
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskType=" + taskType +
                ", deadLine=" + deadLine +
                ", isFinished=" + isFinished +
                ", id=" + id +
                '}';
    }
}
