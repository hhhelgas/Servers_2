package ru.fctk.omsu;

public class ThirdThread extends Thread implements Runnable{
    @Override
    public void run() {
        System.out.println("Third thread is running...");
        try {
            Thread.sleep(3000); // симуляция работы нового потока
            System.out.println("Third thread has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
