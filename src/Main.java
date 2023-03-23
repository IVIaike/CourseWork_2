import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Приветствую, Хозяин! Чего изволите?");
//            System.out.println("Выберите желаемое действие:");
            printMenu();
            if (scanner.hasNext()) {
                int value = scanner.nextInt();
                switch (value) {
                    case 1:
                        TaskService.printActiveTasks();
                        break;
                    case 2:
                        TaskService.addTask(scanner);
                        break;
                    case 3:
                        TaskService.deleteTask(scanner);
                        break;
                    case 4:
                        TaskService.getTaskByCurrentDate(scanner);
                        break;
                    case 5:
                        TaskService.editTask();
                        break;
                    case 6:
                        TaskService.getNextDateTimeExecution();
                        break;
                    case 0:
                        TaskService.printFinishedTasks();
                        break;
                }
            } else {
                scanner.next();
                System.out.println("Выберите желаемое действие:");
            }
        }

    }

    private static void printMenu(){
        System.out.println("1 - вывести список активных задач");
        System.out.println("2 - добавить новую задачу");
        System.out.println("3 - удалить задачу");
        System.out.println("4 - вывести список активных задач на день");
//        System.out.println("5 - редактировать задачу");
//        System.out.println("6 - вывести задачи по датам исполнения");
        System.out.println("0 - вывести список завершенных задач");
    }
}