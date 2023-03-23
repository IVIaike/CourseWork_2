import Tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

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
            System.out.println("Укажите тип задачи: 0 - рабочая, 1 - личная");
            TaskType taskType = TaskType.values()[scanner.nextInt()];
            System.out.println("Укажите периодичность: 1 - разовая, 2 - ежедневная, 3 - еженедельная, 4 - ежемесячная, 5 - ежегодная");
            int checkAvailability = scanner.nextInt();
            System.out.println("Укажите срок выполнения задачи в формате ДД.ММ.ГГГГ ЧЧ:ММ");
            scanner.nextLine();
            createTask(scanner, title, description, taskType, checkAvailability);
            System.out.println("Для выхода нажать Enter\n");
            scanner.nextLine();
        } catch (WrongInputExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createTask(Scanner scanner, String title, String description, TaskType taskType, int checkAvailability) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Available task = null;
            try {
                task = createEvent(checkAvailability, title, description, taskType, eventDate);
                System.out.println("Создана задача " + task);
            }catch (WrongInputExceptions e){
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат ввода данных: dd.MM.yyyy HH:mm и повторите попытку");
            createTask(scanner, title, description, taskType, checkAvailability);
        }

    }

    private static Available createEvent(int checkAvailability, String title, String description, TaskType taskType, LocalDateTime localDateTime) throws WrongInputExceptions {
        if (checkAvailability == 1) {
            OneTimeTask task = new OneTimeTask(title, description, taskType, localDateTime);
            activeTasks.put(task.getId(), task);
            return task;
        } else if (checkAvailability ==2) {
            DailyTask task = new DailyTask(title, description, taskType, localDateTime);
            activeTasks.put(task.getId(), task);
            return task;
        } else if (checkAvailability == 3) {
            WeeklyTask task = new WeeklyTask(title, description,taskType,localDateTime);
            activeTasks.put(task.getId(), task);
            return task;
        } else if (checkAvailability == 4) {
            MonthlyTask task = new MonthlyTask(title, description, taskType, localDateTime);
            activeTasks.put(task.getId(), task);
            return task;
        } else if (checkAvailability == 5) {
            YearlyTask task = new YearlyTask(title, description, taskType, localDateTime);
            activeTasks.put(task.getId(), task);
            return task;
        }
        return null;
    }

    public static void printActiveTasks () {
        for (Available task : activeTasks.values()){
            System.out.println(task);
        }
    }

    public static void printFinishedTasks () {
        for (Available task : finishedTasks.values()){
            System.out.println(task);
        }
    }

    public static void deleteTask (Scanner scanner) {
        System.out.println("Текущие задачи\n");
        printActiveTasks();
        System.out.println("Для удаления введите ID\n");
        int id = scanner.nextInt();
        if(activeTasks.containsKey(id)) {
            Available removedTask = activeTasks.get(id);
            activeTasks.remove(id, removedTask);
            Available.setIsFinished(true);
            finishedTasks.put(id, (Task) removedTask);
            System.out.println("Задача " + id + " перемещена в архив");
        } else {
            System.out.println("Такой задачи не существует");
        }
    }

    public static void getTaskByCurrentDate (Scanner scanner) {
        System.out.println("Укажите нужную дату в формате ДД.ММ.ГГГГ ЧЧ:ММ");
        try {
            String date = scanner.next();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate = LocalDate.parse(date, dateTimeFormatter);
            List<Available> foundTasks = findTaskByCurrentDate(requestedDate);
            System.out.println("Задачи на " + requestedDate + " :");
            for (Available task : foundTasks) {
                System.out.println(task);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат даты");
        }
        scanner.nextLine();
        System.out.println("Для выхода нажмите Enter\n");
    }

    private static List<Available> findTaskByCurrentDate (LocalDate date) {
        List<Available> tasks = new ArrayList<>();
        for (Available task : activeTasks.values()) {
            if (task.checkAvailability(date.atStartOfDay())) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public static void editTask () {}

    public static void getNextDateTimeExecution () {}

}
