package org.gallant.instrumentation.common;

import java.io.Serializable;

/**
 * @author kongyong
 * @date 2019/12/22
 */
public class CountSheepTask implements Serializable {

    private static final long serialVersionUID = -7453286646729244083L;

    public CountSheepTask(){

    }

    public void countSheep(){

        new Thread(() -> {
            int i = 0;
            while(true) {
                try {
                    System.out.println("count sheep:"+i++);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
