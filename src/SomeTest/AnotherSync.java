package SomeTest;

public class AnotherSync {

    public static int B_count=0;

    public synchronized void showA() {
        System.out.println("A-start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A-finished");
    }

    public void showB()  {
        synchronized (this) {
            System.out.println("B"+B_count+++"-start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B"+B_count+++"-finished");
        }
    }
    //当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块
    //当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。
    //synchronized (this)代码块是锁定当前对象twitch





    public void showC() {
        String s = "1";
        synchronized (s) {
            System.out.println("C-start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C-finished");
        }
    }

    public static void main(String[] args) {
        final AnotherSync sy = new AnotherSync();

        //通过调换abc的顺序可以发现锁ab锁相，c与ab不同

        new Thread(new Runnable() {
            public void run() {
                sy.showA();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                sy.showB();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                sy.showB();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                sy.showC();
            }
        }).start();
    }
}
