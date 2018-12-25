package mobi.rayson.foundation.thread;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-28
 *  Time: 上午9:21
 *  Description:
 **/
public class VolatileDemo {

    private volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 10; i++) {
            System.out.println("run: " + i);
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileDemo.increase();
                }
            }).start();
        }
        while (Thread.activeCount()>1){
            System.out.println("Active thread: " + Thread.activeCount());
            Thread.yield();
        }
        System.out.println(volatileDemo.inc);
    }
}
