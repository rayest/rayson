package mobi.rayson.foundation.thread.future;

import java.util.concurrent.*;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-05
 *  Time: 下午4:03
 *  Description: Future 多线程异步调用
 **/
public class FutureDemo implements Callable<String> {

    private String para;

    private FutureDemo(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(para);
            Thread.sleep(100); // 模拟处理时间
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new FutureDemo("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);
        System.out.println("请求完毕");
        Thread.sleep(2000); // 模拟处理其他的业务
        System.out.println("data:" + futureTask.get());
    }
}
