package ru.fctk.omsu;

public class SecondThread extends Thread implements Runnable{
    @Override
    public void run() {
        System.out.println("Second thread is running...");
        try {
            Thread.sleep(3000); // симуляция работы нового потока
            System.out.println("Second thread has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
