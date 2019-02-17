package com.lay.threadlocal;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 21:20 2019/2/17
 * @Modified By:IntelliJ IDEA
 */
public class SequenceB implements Sequence {
    private static ThreadLocal<Integer> numberContainer=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNumber() {
        numberContainer.set(numberContainer.get()+1);
        return numberContainer.get();
    }

    public static void main(String[] args){
        Sequence sequence = new SequenceB();

        ClientThread thread1 = new ClientThread("Thread 1",sequence);
        ClientThread thread2 = new ClientThread("Thread 2",sequence);
        ClientThread thread3 = new ClientThread("Thread 3",sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
