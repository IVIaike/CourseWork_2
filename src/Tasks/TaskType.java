package Tasks;

public enum TaskType {
    WORK(1,"work"), PERSONAL(2, "personal");

    private int index;
    private String name;

    TaskType(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getI() {
        return index;
    }

    public String getName() {
        return name;
    }
}
