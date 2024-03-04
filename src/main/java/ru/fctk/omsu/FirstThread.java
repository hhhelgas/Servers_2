package ru.fctk.omsu;

public class FirstThread extends Thread implements Runnable{
    @Override
    public void run() {
        System.out.println("First thread is running...");
                try {
                    Thread.sleep(3000); // симуляция работы нового потока
        System.out.println("First thread has finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }
}
