public class SingletonEager {
    private static final SingletonEager obj = new SingletonEager();

    // Constructor
    private SingletonEager() {
        System.out.println("<>--Creating-an-Object--<>");
    }

    // getter
    public static SingletonEager getObj () {
        return obj;
    }
}