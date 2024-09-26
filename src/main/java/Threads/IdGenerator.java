package Threads;

public abstract class IdGenerator {
    private static int idCounter = 0;
    public static synchronized int getNextId() {
        return ++idCounter;

    }
}
