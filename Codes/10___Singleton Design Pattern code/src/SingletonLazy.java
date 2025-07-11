public class SingletonLazy {
    // Changes made by one thread to obj are immediately
    // visible to other threads.
    private static volatile SingletonLazy obj;

    // Constructor
    private SingletonLazy() {
        System.out.println("<>--Creating-an-Object--<>");
    }

    // getter
    public static SingletonLazy getObj () {
        // 🔐 Lock is a very expensive operation
        // so we check nullability before locking
            if (obj == null) {
                synchronized (SingletonLazy.class){
                    // double check if multiple thread
                    // enter simultaneously
                    if (obj == null){
                        obj = new SingletonLazy();
                    }
                }
            }
        return obj;
    }
}