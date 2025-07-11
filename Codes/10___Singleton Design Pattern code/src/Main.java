public class Main {
    public static void main(String[] args) {
        SingletonLazy objLazy = SingletonLazy.getObj();
        SingletonLazy objLazy1 = SingletonLazy.getObj();
        SingletonEager objEager = SingletonEager.getObj();
        SingletonEager objEager1 = SingletonEager.getObj();

        System.out.println(objLazy == objLazy1);
        System.out.println(objEager == objEager1);
    }
}
