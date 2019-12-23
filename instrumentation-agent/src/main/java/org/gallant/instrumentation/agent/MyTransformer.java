package org.gallant.instrumentation.agent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import org.gallant.instrumentation.common.CountSheepTask;

/**
 * @author kongyong
 * @date 2019/12/22
 */
public class MyTransformer implements ClassFileTransformer {

    private String beingRedefinedClassName = "org/gallant/instrumentation/common/CountSheepTask";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        System.out.println("###### start transform");
        System.out.println(String.format("loader:%s, className:%s, classBeingRedefined:%s\nbeingRedefinedClassName:%s", loader, className, classBeingRedefined, beingRedefinedClassName));
        // 重新读取class文件返回，此时的class文件已经被修改增强
        byte[] bytes = new byte[0];
        if (beingRedefinedClassName.equals(className)) {
            bytes = getBytes();
        } else {
            StackPrintUtil.printStatck();
        }
        System.out.println("###### end transform");
        return bytes;

    }

    private byte[] getBytes(){
        byte[] bytes = new byte[0];
        File clz = new File("D:\\git\\private\\instrumentation\\instrumentation-agent\\src\\main\\resources\\CountSheepTask.class");
        try (FileInputStream fis = new FileInputStream(clz)) {
            bytes = new byte[(int) clz.length()];
            int fileLen = fis.read(bytes);
            System.out.println("########## class len:"+clz.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("########## bytes len:"+bytes.length);
        return bytes;
    }
}
