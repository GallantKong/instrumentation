package org.gallant.instrumentation.attach;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kongyong
 * @date 2019/12/22
 */
public class AttachMain {

    public static void main(String[] args)
            throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        String targetJvmMainName = "org.gallant.instrumentation.main.Main";
        URL url = AttachMain.class.getClassLoader().getResource("my-agent-jar-with-dependencies.jar");
        String agentJarPath = url == null ? null : url.toString().substring(6);
        System.out.println(agentJarPath);
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        VirtualMachineDescriptor descriptor = list.stream()
                .filter(vmd -> vmd.displayName().contains(targetJvmMainName))
                .collect(Collectors.toList()).get(0);
        VirtualMachine attach = VirtualMachine.attach(descriptor);
        attach.loadAgent(agentJarPath);
        System.exit(0);
    }

}
