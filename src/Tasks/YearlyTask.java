package Tasks;

import java.time.LocalDateTime;

public class YearlyTask extends Task implements Available {
    public YearlyTask(String title, String description, TaskType taskType, LocalDateTime taskDateTime) throws WrongInputExceptions {
        super(title, description, taskType, taskDateTime);
    }

    @Override
    public boolean checkAvailability(LocalDateTime requestDate) {
        return getDeadLine().getDayOfYear()==requestDate.getDayOfYear();
    }
}
