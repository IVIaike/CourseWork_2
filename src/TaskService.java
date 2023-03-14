import Tasks.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskService {
    private static final Map<Integer, Task> activeTasks = new HashMap<>();
    private static final Map<Integer, Task> finishedTasks = new HashMap<>();


    public static void addTask (Scanner scanner){
        try {
            scanner.nextLine();
            System.out.println("Введите название задачи:");
            String title = ValidationUtils.validateString(scanner.nextLine());
            System.out.println("Введите описание задачи:");
            String description = ValidationUtils.validateString(scanner.nextLine());
            System.out.println("Укажите тип задачи: 1 - рабочая, 2 - личная");
            TaskType taskType = TaskType.valueOf(scanner.nextLine());
            System.out.println("Укажите периодичность: 1 - разовая, 2 - ежедневная, 3 - еженедельная, 4 - ежемесячная, 5 - ежегодная");
            int checkAvailability = scanner.nextInt();
            System.out.println("Укажите срок выполнения задачи в формате ДД-ММ-ГГГГ ЧЧ-ММ:");
            scanner.nextLine();
// Как тут собрать данные в конструктор???

        } catch (WrongInputExceptions e) {
            throw new RuntimeException(e);
        }
    }


    public static void editTask () {}

    public static void printActiveTasks () {}

    public static void deleteTask () {}

    public static void printFinishedTasks () {}

    public static void getTaskByCurrentDate () {}

//    public static void getNextDateTimeExecution () {}

}
