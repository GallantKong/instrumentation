package org.gallant.instrumentation.main;

import org.gallant.instrumentation.common.CountSheepTask;

/**
 * @author kongyong
 * @date 2019/12/22
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Main.before.CountSheepTask.class.cl:"+ CountSheepTask.class.getClassLoader());
            new CountSheepTask().countSheep();
            Thread.sleep(1000 * 10);
            System.out.println("Main.after.CountSheepTask.class.cl:"+CountSheepTask.class.getClassLoader());
            new CountSheepTask().countSheep();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
