package mobi.rayson.foundation.thread.cyclicBarrierDemo;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午2:43
 *  Description:
 **/

public class BarrierRun implements Runnable {
    private boolean isTaskFinished;
    private int N;

    BarrierRun(boolean isTaskFinished, int n) {
        this.isTaskFinished = isTaskFinished;
        this.N = n;
    }

    @Override
    public void run() {
        if (isTaskFinished) {
            System.out.println("司令：[士兵" + N + "个，任务完成！]");
        } else {
            System.out.println("司令：[士兵" + N + "个，集合完毕！]");
            isTaskFinished = true;
        }
    }
}
