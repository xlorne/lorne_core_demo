# lorne_core_demo
lorne_core demo演示项目

### 项目依赖服务
1. redis服务
2. mysql数据库

### 使用教程
1. 需要将qrtz.sql导入mysql数据库
2. 修改quart.properties配置文件关于mysql数据库的链接配置
3. 修改redis.properties配置文件中的ip port
4. 运行tomcat，运行DemoControllerTest的list和addJob方法测试
5. 其他测试可直接通过测试类下的demo下查看。