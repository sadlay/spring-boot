package com.lay.threadlocal;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 21:02 2019/2/17
 * @Modified By:IntelliJ IDEA
 */
public class ClientThread extends Thread {
    private Thread t;
    private String threadName;
    private Sequence sequence;

    public ClientThread(String threadName,Sequence sequence) {
        this.threadName=threadName;
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " => " + sequence.getNumber());
        }
    }
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
