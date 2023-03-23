package Tasks;

import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Available {
    public MonthlyTask(String title, String description, TaskType taskType, LocalDateTime taskDateTime) throws WrongInputExceptions {
        super(title, description, taskType, taskDateTime);
    }

    @Override
    public boolean checkAvailability(LocalDateTime requestDate) {
        return getDeadLine().getDayOfMonth()==requestDate.getDayOfMonth();
    }
}
