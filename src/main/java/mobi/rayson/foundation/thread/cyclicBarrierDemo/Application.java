package mobi.rayson.foundation.thread.cyclicBarrierDemo;

import java.util.concurrent.CyclicBarrier;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午2:57
 *  Description:
 **/
public class Application {

    public static void main(String[] args) {
        int parties = 10;
        Thread[] soldiers = new Thread[parties];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, new BarrierRun(false, parties));
        System.out.println("集合队伍!");
        for (int i = 0; i < parties; i++) {
            System.out.println("士兵 " + i + " 报道!");
            soldiers[i] = new Thread(new Soldier(cyclicBarrier, "士兵" + i));
            soldiers[i].start();
        }
    }
}
