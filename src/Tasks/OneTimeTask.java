package Tasks;

import java.time.LocalDateTime;

public class OneTimeTask extends Task implements Available {
    public OneTimeTask(String title, String description, TaskType taskType, LocalDateTime taskDateTime) throws WrongInputExceptions {
        super(title, description, taskType, taskDateTime);
    }

    @Override
    public boolean checkAvailability(LocalDateTime requestedDate) {
        return getDeadLine().toLocalDate().equals(requestedDate.toLocalDate());
    }
}
