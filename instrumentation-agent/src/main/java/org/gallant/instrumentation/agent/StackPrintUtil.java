package org.gallant.instrumentation.agent;

/**
 * @author kongyong
 * @date 2019/12/23
 */
public class StackPrintUtil {

    public static void printStatck() {
        System.out.println("-----------------------------------");
        StackTraceElement[] stackElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackElements) {
            String msg = String.format("%s.%s(%s)", stackTraceElement.getClassName(),
                    stackTraceElement.getMethodName(), stackTraceElement.getLineNumber());
            System.out.println(msg);
        }
        System.out.println("-----------------------------------");
    }

}
