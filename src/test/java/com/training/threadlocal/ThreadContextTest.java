package com.training.threadlocal;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.System.out;
import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertEquals;

public class ThreadContextTest {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    @Test
    public void threadContextTest() throws InterruptedException, BrokenBarrierException {
        Thread thread1 = new Thread(getRunnable(1));
        Thread thread2 = new Thread(getRunnable(2));
        Thread thread3 = new Thread(getRunnable(3));

        thread1.start();
        thread2.start();
        thread3.start();

        out.println("All thread will be started after 2 sec!");
        sleep(2000);
        cyclicBarrier.await();
        out.println("All thread are started!");

        thread1.join();
        thread2.join();
        thread3.join();
        out.println("All thread are finished!");
    }

    private Runnable getRunnable(int num) {
        return new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                cyclicBarrier.await();
                out.println(Thread.currentThread().getName() + " is stated!!");
                String userName = "User " + num;
                Context context = new Context(userName);
                ThreadContext.setContext(context);
                sleep(3000);
                assertEquals(ThreadContext.getContext(), context);
            }
        };
    }

}
