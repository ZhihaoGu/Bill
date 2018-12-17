package SomeTest;

public class SyncThread {
    public static void main(String[] args) {

        SyncThread Ademo = new SyncThread();
        // 修饰对象实列方法 锁定的当前实列对象 必须是公用同一个对象才行

        new Thread("thread1"){
            public void run(){
                try {
                    for(int i=0;i<5;i++){
                        Ademo.demo();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("thread2"){
            public void run(){
                try {
                    for(int i=0;i<5;i++){
                        Ademo.demo();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public static int count=0;

    public synchronized void demo() throws InterruptedException{
        System.out.println("当前线程名=="+Thread.currentThread().getName()+" 当前count值=="+ count++);
        //休眠,造成两个线程同时访问本实列方法
        Thread.sleep(500);
    }

}
