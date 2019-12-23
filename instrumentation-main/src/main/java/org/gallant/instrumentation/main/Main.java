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
            // 重新转换或定义类之后，不用重新创建实例，变更后的方法已经生效，直接调用即可，也就是说下面的main2方法也会执行增强后的方法
            System.out.println("Main.after.CountSheepTask.class.cl:"+CountSheepTask.class.getClassLoader());
            new CountSheepTask().countSheep();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main2() {
        try {
            System.out.println("Main.before.CountSheepTask.class.cl:"+ CountSheepTask.class.getClassLoader());
            CountSheepTask task = new CountSheepTask();
            task.countSheep();
            Thread.sleep(1000 * 10);
            System.out.println("Main.after.CountSheepTask.class.cl:"+CountSheepTask.class.getClassLoader());
            task.countSheep();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
