package Algorithm.string;

import java.util.HashSet;

public class Singleton {
    private volatile static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null) {
            synchronized (Singleton.class){
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    {
        System.out.println("代码块");
    }
    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("正常");
        HashSet<Integer> integers = new HashSet<>();
    }
}
