package com.lay.threadlocal;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 21:04 2019/2/17
 * @Modified By:IntelliJ IDEA
 */
public class SequenceA implements Sequence {
    private static int number = 0;

    public int getNumber() {
        return ++number;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();

        ClientThread thread1 = new ClientThread("Thread 1",sequence);
        ClientThread thread2 = new ClientThread("Thread 2",sequence);
        ClientThread thread3 = new ClientThread("Thread 3",sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
