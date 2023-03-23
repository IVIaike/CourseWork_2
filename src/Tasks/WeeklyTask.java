package Tasks;

import java.time.LocalDateTime;

public class WeeklyTask extends Task implements  Available {
    public WeeklyTask(String title, String description, TaskType taskType, LocalDateTime taskDateTime) throws WrongInputExceptions {
        super(title, description, taskType, taskDateTime);
    }

    @Override
    public boolean checkAvailability(LocalDateTime requestedDate) {
        return getDeadLine().getDayOfWeek().equals(requestedDate.getDayOfWeek());
    }
}
