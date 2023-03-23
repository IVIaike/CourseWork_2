package Tasks;

public enum TaskType {
    WORK(0,"рабочая"), PERSONAL(1, "личная");

    public final int value;
    public final String name;


    TaskType(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
