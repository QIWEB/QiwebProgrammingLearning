## Java高级程序员面试题
<pre>
1.你认为项目中最重要的过程是那些？
分析、设计阶段  尽量找出进度的优先级
2.如果给你一个4-6人的team，怎么分配？
挑选一技术过硬的人作为我的替补。其它人平均分配任务，每周进行全面的任务分配，每个人领取一周的工作量
，每天汇报进度。
3.简述软件开发文档?
需求分析、概要设计、详细设计、操作手册、测试计划
4.你认为一个项目如何才正确？
 是企业利益最大化。
5.你经常读那些书？
Java编程思想 Java模式  人月神话
6.springmvc的工作原理?
   客户端请求提交到DispacherServlet
   由DispacherServlet控制器查询HandlerMapping，找到处理请求的Controller
   Controller调用业务逻辑处理后，返回ModelAndView
   DispacherServlet查询视图解析，找到ModelAndView指定的视图
   视图负责将结果显示到客户端
7.springmvc 和struts2的区别?
机制 ：springmvc 的入口是servlet,struts2的入口是filter
性能 ： springmvc 会比struts2快一点。springmvc是基于方法设计，struts2是基于类，每次发一次请求都会实例一个action,每个Action都会被注入属性。
参数传递：struts2是在接受参数的时候，可以采用属性来接收参数，这家说明可以让多个方法共享
拦截器机制：struts2有自己的interceptor机制，springmvc用的是独立的AOP方式，strtus2的配置文件还是比springmvc大，springmvc使用简洁，springMVC比struts2开发效率要高.
8.struts2工作原理？
客户端初始化一个执行servlet的请求
这个请求经过一系列的过滤器，被FilterDispatcher调用，询问ActionMapper来决定是否调用Action
FilterDispatcher把请求的处理交给ActionProxy
ActionProxy通过Configuraction Manager询问相关的配置文件，找到需要的Action类
ActionProxy创建ActionInvocation的实例
ActionInvocation调用Action前后的拦截器
Action执行完毕后，根据struts.xml配置文件找到对应的视图页面
9.Hibernate 工作原理？
读取并解析配置文件
创建SessionFactory
打开Session
创建事务：transaction
持久化操作
提交事务
关闭Session
关闭SessionFactory
10.为什么要用spring?
spring能够很好的和各大框架整合
spring 通过IOC容器管理了对象的创建和销毁  工厂模式
在使用hiberna，mybatis的时候，不用每次都编写提交的事务的代码，可以使用spring的AOP来管理事务      AOP其实就是一个动态代理的实现
 
声明式事务和编程式事务
 
11.mybatis的优缺点？
    优点：SQL写在XML中，便于统一管理和优化
               提供映射标签，支持对象和数据库的orm字段关系映射
               可以对SQL进行优化
     缺点： SQL工作量大
                 mybagtis移植姓不好
                 不支持级联 
12.谈谈SSH整合?
   struts(表示层)+spring(业务层)+hibernate(持久层)
   struts是一个表示层的框架，主要用于接收请求，分发请求。struts其实属于MVC中的VC层次的
   hibernate是一个持久层的框架，主要负责与关系数据库的操作
   spring是一个业务层的框架，是一个整合的框架，能够很好的黏合表示层和持久层。
 
13.maven是什么?有什么作用？
   是一个项目管理、构建工具
   作用：帮助下载jar   寻找依赖，帮助下载依赖   热部署、热编译
   
14.WEB 前端优化？
  减少HTTP请求的数量（合并css、js、图片）
  利用浏览器的缓存机制
  利用GZIP压缩机制：只针对文本类资源有效
  把CSS文件放在HTML开头
  把javascript文件放在HTML结尾
  避免CSS表达式（判断浏览器）
  使用javascript压缩
  减少DNS查找
  避免重定向
  使用ajax
 
15.安全性测试
     利用安全性测试技术，找到潜在的漏洞
 
16.事务隔离级别（4种）
    Serializable(串行化)：一个事务在执行过程中完全看不到其他事物对数据库所做的更新（事务执行的时候不允许别的事务并发执行，事务只能一个接着一个地执行，而不能并发执行）
   Repeatable Read（可重复读）：一个事务在执行过程中可以看到其它事务已经提交的新插入的记录，但是不能看到其它事务对已有记录的更新
  Read Commited（读已提交数据）：一个事务在执行过程中可以看到其它事务已经提交的新插入的记录，而且能看到其它事务已经提交的对已有记录的更新。
   Read Uncommitted（读未提交数据）：一个事务在执行过程中可以看到其它事务没有提交的新插入的记录的更新，而且能看其它事务没有提交到对已有记录的更新
17.MYSQL存储引擎（4种）
   MyISAM它不支持事务，也不支持外键，尤其是访问速度快，对事务完整性没有要求或者以SELECT、INSERT为主的应用基本都可以使用这个引擎来创建表。
每个MyISAM在磁盘上存储成3个文件，其中文件名和表名都相同，但是扩展名分别为：

.frm(存储表定义)
MYD(MYData，存储数据)
MYI(MYIndex，存储索引)
InnoDB
InnoDB存储引擎提供了具有提交、回滚和崩溃恢复能力的事务安全。但是对比MyISAM的存储引擎，InnoDB写的处理效率差一些并且会占用更多的磁盘空间以保留数据和索引。
1)自动增长列2)外键约束
MEMORY
memory使用存在内存中的内容来创建表。每个MEMORY表实际对应一个磁盘文件，格式是.frm。MEMORY类型的表访问非常快，因为它到数据是放在内存中的，并且默认使用HASH索引，但是一旦服务器关闭，表中的数据就会丢失，但表还会继续存在。
MERGE
 merge存储引擎是一组MyISAM表的组合，这些MyISAM表结构必须完全相同，MERGE表中并没有数据，对MERGE类型的表可以进行查询、更新、删除的操作，这些操作实际上是对内部的MyISAM表进行操作。
 
18.事务传播特性
1. PROPAGATION_REQUIRED: 如果存在一个事务，则支持当前事务。如果没有事务则开启
2. PROPAGATION_SUPPORTS: 如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行
3. PROPAGATION_MANDATORY: 如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常。
4. PROPAGATION_REQUIRES_NEW: 总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起。
5. PROPAGATION_NOT_SUPPORTED: 总是非事务地执行，并挂起任何存在的事务。
6. PROPAGATION_NEVER: 总是非事务地执行，如果存在一个活动事务，则抛出异常
7. PROPAGATION_NESTED：如果一个活动的事务存在，则运行在一个嵌套的事务中. 如果没有活动事务, 
 
 
 
20.TCP协议（传输控制协议Transmission Control Protocol ）
    建立链接：三次握手(1.给对方拨号 2.喂，您好，请问是哪位 3 我是小刘)
    关闭链接：四次挥手

    保证可靠
 
21.shiro 是什么
  Apache Shiro 是一个强大易用的java安全框架，提供了认证、授权、加密和会话管理等功能。
认证 ：验证用户来核实他们的身份
授权：
会话管理
 
22.  项目技术
       前台：面向的客户
       前端：css div js jquery 
       后端：springmvc spring mybatis
       使用的优化技术：
            1.页面静态化（Freemarker）
            2.缓存
                  2.1 页面缓存（OSCache）
                  2.2 分布式缓存（memcached）
             3.   图片分离（服务器）
             4.负载均衡（解决高并发终极策略）
        后台：（管理对象）
            前端：css html js jquery 
            后端：springmvc spring  mybatis
         数据库：mysql
         图片分离框架：jersey
         
          注意：div table 区别  为什么前台使用div 而非table标签  div可以一块一块进行加载
 
 
23.什么RESTful（表现层状态转化）架构？
       （1）每一个URI代表一种资源；

　　（2）客户端和服务器之间，传递这种资源的某种表现层；

　　（3）客户端通过四个HTTP动词，对服务器端资源进行操作，实现"表现层状态转化"。