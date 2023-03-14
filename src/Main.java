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
                        TaskService.getTaskByCurrentDate();
                        break;
                    case 3:
                        TaskService.addTask(scanner);
                        break;
                    case 4:
                        TaskService.editTask();
                        break;
                    case 5:
                        TaskService.deleteTask();
                        break;
                    case 6:
                        TaskService.printFinishedTasks();
                        break;
                    case 0:
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
        System.out.println("2 - вывести список активных задач на день");
        System.out.println("3 - создать задачу");
        System.out.println("4 - редактировать задачу");
        System.out.println("5 - удалить задачу");
        System.out.println("6 - вывести список завершенных задач");
    }
}