package Tasks;

import java.time.LocalDateTime;

public interface Available {
    boolean checkAvailability (LocalDateTime localDateTime);
    public static void setIsFinished(boolean finished) {}
}
