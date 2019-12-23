package org.gallant.instrumentation.agent;

import java.lang.instrument.Instrumentation;
import org.gallant.instrumentation.common.CountSheepTask;

/**
 * @author kongyong
 * @date 2019/12/22
 */
public class MyAgent {

    public static void premain(String args, Instrumentation inst) {
        main(args, inst);
    }

    public static void agentmain(String args, Instrumentation inst) {
        main(args, inst);
    }

    private static synchronized void main(String args, final Instrumentation inst) {
        System.out.println("###### MyAgent start");
        try {
            System.out.println(
                    "###### MyAgent.CountSheepTask.getClassLoader:" + CountSheepTask.class
                            .getClassLoader());
            MyTransformer myTransformer = new MyTransformer();
            inst.addTransformer(myTransformer, true);
            inst.retransformClasses(CountSheepTask.class);
            System.out.println("###### retransformClasses end");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("###### MyAgent end");
    }
}
