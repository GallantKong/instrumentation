# instrumentation
1. 打包agent（包含增强后的CountSheepTask源码用于在attach依附目标JVM后替换原class定义）
2. 将agent拷贝至attach的resource目录，attach时需要为目标JVM加载agent
3. 启动main module中的Main类
4. 启动attach module中的AttachMain类，10s后会调用增加后的方法
