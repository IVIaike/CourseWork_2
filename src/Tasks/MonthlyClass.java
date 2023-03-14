package Tasks;

import java.time.LocalDateTime;

public class MonthlyClass extends Task implements Available {
    public MonthlyClass(String title, String description, TaskType taskType, LocalDateTime taskDateTime) throws WrongInputExceptions {
        super(title, description, taskType, taskDateTime);
    }

    @Override
    public boolean checkAvailability(LocalDateTime requestDate) {
        return getDeadLine().getDayOfMonth()==requestDate.getDayOfMonth();
    }
}
