package com.lay.spring.async.thread;
/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:05 2019/8/16
 * @Modified By:IntelliJ IDEA
 */


public class TerminalTest {
    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {
            printSchedule(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 进度条总长度
     */
    private static int TOTLE_LENGTH = 30;
    public static void printSchedule(int percent){
        for (int i = 0; i < TOTLE_LENGTH + 10; i++) {
            System.out.print("\b");
        }
        //░▒
        int now = TOTLE_LENGTH * percent / 100;
        for (int i = 0; i < now; i++) {
            System.out.print(">");
        }
        for (int i = 0; i < TOTLE_LENGTH - now; i++) {
            System.out.print(" ");
        }
        System.out.print("  " + percent + "%");
    }

}
