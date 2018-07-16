package com.example.tansaction2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tansaction2ApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void tete() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 12, 200000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(8));

        for (int i = 0; i < 30; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }


    class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.currentThread().sleep(40000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }


    /**
     * 普通冒泡排序
     */
    @Test
    public void maopao() {
        int[] arr = new int[]{5, 6, 4, 8, 2, 0, 1, 7};

        int tmp=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }

    /**
     * 普通冒泡排序进阶1
     */
    @Test
    public void maopao1() {
        int[] arr = new int[]{5, 6, 4, 8, 2, 0, 1, 7};

        int tmp=0;
        for (int i = 0; i < arr.length; i++) {
            //有序标记，每一轮的初始是true
            boolean issorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    //有元素交换，所以不是有序的，标记为false
                    issorted = false;
                }
            }
            if (issorted)
                break;
        }

    }


    /**
     * 普通冒泡排序进阶2
     */
    @Test
    public void maopao2() {
        int[] arr = new int[]{5, 6, 4, 8, 2, 0, 1, 7};

        int tmp=0;
        //记录最后一次交换位置
        int lastExchangeIndex=0;
        //无序数列的边界，每次比较只需比到这里为止
        int sortBord=arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            //有序标记，每一轮的初始是true
            boolean issorted = true;
            for (int j = 0; j < sortBord; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    //有元素交换，所以不是有序的，标记为false
                    issorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex=j;
                }
            }
            sortBord=lastExchangeIndex;
            if (issorted)
                break;
        }

    }

}
