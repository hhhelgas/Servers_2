package ru.fctk.omsu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    //Напечатать все свойства текущего потока.

        //Напечатать все свойства текущего потока.
        Thread currentThread = Thread.currentThread();
        System.out.println("Properties of current thread:");
        System.out.println("Thread ID: " + currentThread.getId());
        System.out.println("Thread Name: " + currentThread.getName());
        System.out.println("Thread Priority: " + currentThread.getPriority());
        System.out.println("Thread StackTrace: " + Arrays.toString(currentThread.getStackTrace()));
        System.out.println("Thread State: " + currentThread.getState());
        System.out.println("Thread Group: " + currentThread.getThreadGroup().getName());
        System.out.println("Thread isAlive: " + currentThread.isAlive());
        System.out.println("Thread isDaemon: " + currentThread.isDaemon());
        System.out.println("Thread isInterrupted: " + currentThread.isInterrupted());
        System.out.println("____________________");

        //Создать новый поток и дождаться его окончания в первичном потоке.

        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New thread is running...");
//                try {
//                    Thread.sleep(3000); // симуляция работы нового потока
                    System.out.println("New thread has finished.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        newThread.start();

        try {
            newThread.join(); //Waits for this thread to die.

            System.out.println("Primary thread continues after new thread has finished.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("____________________");
//        Создать 3 новых потока и дождаться окончания их всех в первичном потоке. Для
//        каждого потока создать свой собственный класс.
        //TODO: есть ли разница в каком порядке создавать потоки?
        FirstThread firstThread = new FirstThread();
        firstThread.start();
        SecondThread secondThread = new SecondThread();
        secondThread.start();
        ThirdThread thirdThread = new ThirdThread();
        thirdThread.start();
        try {
            firstThread.join();
            secondThread.join();
            thirdThread.join();
            System.out.println("Primary thread continues after 1st, 2nd and 3rd have finished.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    //“Ping Pong”, задача заключается в том, чтобы бесконечно выводить на консоль
    //сообщения “ping” или “pong” из двух разных потоков. При этом сообщения обязаны
    //чередоваться, т.е. не может быть ситуации, когда ping или pong появляется в
    //консоли более одного раза подряд.

}