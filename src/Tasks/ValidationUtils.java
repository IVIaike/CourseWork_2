package Tasks;

public class ValidationUtils {

    public static String validateString(String value) throws WrongInputExceptions {
        if (value == null || value.isBlank() || value.isEmpty()) {
            throw new WrongInputExceptions("Это поле не может быть пустым!");
        }
        return value;
    }
}
