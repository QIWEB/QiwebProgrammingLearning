<pre>
===java 常用的三大集合===
一、Set集合。其主要实现类有HashSet、TreeSet。存放对象的引用，不允许有重复对象。 
1.HashSet：调用对象的hashCode（）方法，通过比较哈希码与equals（）方法来判别是否重复
2.TreeSet：继承ShortedSet接口，能够对集合中对象排序

二、List集合，其主要实现类有LinkedList、ArrayList，前者实现了链表结构，后者可代表大小可变的数组。
List的特点是能够以线性方式储蓄对象，并允许存放重复对象

1.List:线性集合接口，有序；ArrayList：动态数组[可变长度的动态数组]；
2.LinkedList：链表结构的集合

那么为了解决这个线程安全问题你可以这么使用Collections.synchronizedList()，如：

List<Map<String,Object>> data=Collections.synchronizedList(new ArrayList<Map<String,Object>>());

三、Map集合，其主要实现类有HashMap、TreeMap，Map对值没有唯一性要求，对健要求唯一，
TreeMap，可自然排序，也可通过传递Comparator的实现类构造TreeMap。


===spring和springMVC===
一：spring框架介绍
    它是一个全栈式框架，提供了从表层到业务层再到持久层的一套完整解决方案。
    它的两大核心IoC和AOP为我们程序解耦和代码简洁易维护提供了支持。

1：AOP=面向切面编程，用来封装横切关注点，使用场景-权限，缓存，持久化，同步，事务等。

2：IOC=控制反转，通常由调用者来创建被调用者的实例对象，但在spring中创建被调用者的工作不再由调用者来完成，因此称为控制反转。

3：spring常见创建对象的注解：@Component@Controller@ Service@ Repository

4：Spring中用到的设计模式：简单工厂、工厂方法、单例模式、适配器、包装器、代理、观察者、策略、模板方法

5：Spring的优点：
  1.降低了组件之间的耦合性 ，实现了软件各层之间的解耦 
  2.可以使用容易提供的众多服务，如事务管理，消息服务等 
  3.容器提供单例模式支持 
  4.容器提供了AOP技术，利用它很容易实现如权限拦截，运行期监控等功能 
  5.容器提供了众多的辅助类，能加快应用的开发 
  6.spring对于主流的应用框架提供了集成支持，如hibernate，JPA，Struts等 
  7.spring属于低侵入式设计，代码的污染极低 
  8.独立于各种应用服务器 

6：Spring管理事务有几种方式：
  1、编程式事务，在代码中硬编码。(不推荐使用)

  2、声明式事务，在配置文件中配置（推荐使用）
      
      声明式事务又分为两种：
     a、基于XML的声明式事务
     b、基于注解的声明式事务

事务传播行为介绍: 
@Transactional(propagation=Propagation.REQUIRED)
	如果有事务， 那么加入事务， 没有的话新建一个(默认情况下)
@Transactional(propagation=Propagation.NOT_SUPPORTED) 
	容器不为这个方法开启事务
@Transactional(propagation=Propagation.REQUIRES_NEW) 
	不管是否存在事务，都创建一个新的事务，原来的挂起，新的执行完毕，继续执行老的事务
@Transactional(propagation=Propagation.MANDATORY) 
	必须在一个已有的事务中执行，否则抛出异常
@Transactional(propagation=Propagation.NEVER)
	必须在一个没有的事务中执行，否则抛出异常(与Propagation.MANDATORY相反)
@Transactional(propagation=Propagation.SUPPORTS) 
	如果其他bean调用这个方法，在其他bean中声明事务，那就用事务。如果其他bean没有声明事务，那就不用事务

事务隔离级别:

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	读取未提交数据(会出现脏读， 不可重复读) 基本不使用
@Transactional(isolation = Isolation.READ_COMMITTED)(SQLSERVER默认)
	读取已提交数据(会出现不可重复读和幻读)
@Transactional(isolation = Isolation.REPEATABLE_READ)
	可重复读(会出现幻读)
@Transactional(isolation = Isolation.SERIALIZABLE)
	串行化

事务超时设置:
@Transactional(timeout=30) //默认是30秒



7：spring中自动装配的方式有哪些：
   1：NO，2：byName,3:byType,4:default

8:spring中的核心类有那些，各有什么作用:
   BeanFactory：产生一个新的实例，可以实现单例模式
   BeanWrapper：提供统一的get及set方法
   ApplicationContext:提供框架的实现，包括BeanFactory的所有功能

9:spring有两种代理方式：
  1:spring使用JDK的java.lang.reflect.Proxy类代理。
  2:spring使用CGLIB库生成目标对象的子类

10:springMVC的流程:
   用户发送请求->收到请求调用HandlerMapping处理器映射器->
   执行处理器(Controller，也叫后端控制器)->
   将controller执行结果ModelAndView返回给DispatcherServlet->
   传给ViewReslover视图解析器->
   解析后返回具体View

11:Spring中@Transactional事务回滚
  事务声明例子：@Transactional(propagation=Propagation.NOT_SUPPORTED)
  Propagation支持7种不同的传播机制：

REQUIRED：如果存在一个事务，则支持当前事务。如果没有事务则开启一个新的事务。

SUPPORTS： 如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行。但是对于事务同步的事务管理器，PROPAGATION_SUPPORTS与不使用事务有少许不同。

NOT_SUPPORTED：总是非事务地执行，并挂起任何存在的事务。

REQUIRESNEW：总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起。

MANDATORY：如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常。

NEVER：总是非事务地执行，如果存在一个活动事务，则抛出异常

NESTED：如果一个活动的事务存在，则运行在一个嵌套的事务中。如果没有活动事务，则按REQUIRED属性执行。

下面是一些需要注意的事项：
  1：@Transactional 注解可以被应用于接口定义和接口方法、类定义和类的 public 方法上。
  2：@Transactional 注解只能应用到 public 可见度的方法上。
  3：注意仅仅 @Transactional 注解的出现不足于开启事务行为，它仅仅 是一种元数据。必须在配置文件中使用配置元素，才真正开启了事务行为
  4：通过 元素的 “proxy-target-class” 属性值来控制是基于接口的还是基于类的代理被创建。如果 “proxy-target-class” 属值被设置为 “true”，那么基于类的代理将起作用（这时需要CGLIB库cglib.jar在CLASSPATH中）。如果 “proxy-target-class” 属值被设置为 “false” 或者这个属性被省略，那么标准的JDK基于接口的代理将起作用。
  5：Spring团队建议在具体的类（或类的方法）上使用 @Transactional 注解，而不要使用在类所要实现的任何接口上。在接口上使用 @Transactional 注解，只能当你设置了基于接口的代理时它才生效。因为注解是 不能继承 的，这就意味着如果正在使用基于类的代理时，那么事务的设置将不能被基于类的代理所识别，而且对象也将不会被事务代理所包装。
  6：@Transactional 的事务开启 ，或者是基于接口的 或者是基于类的代理被创建。所以在同一个类中一个方法调用另一个方法有事务的方法，事务是不会起作用的。

==============SpringBoot========================
简介：

    微服务架构，为基于 Spring 的开发提供更快的入门体验

　　开箱即用，没有代码生成，也无需 XML 配置。同时也可以修改默认值来满足特定的需求。

　　提供了一些大型项目中常见的非功能特性，如嵌入式服务器、安全、指标，健康检测、外部配置等。

　　Spring Boot 并不是对 Spring 功能上的增强，而是提供了一种快速使用 Spring 的方式。

1：Spring Boot Starter的工作原理
     1. Spring Boot 在启动时扫描项目所依赖的JAR包，寻找包含spring.factories文件的JAR

     2. 根据spring.factories配置加载AutoConfigure类

     3. 根据 @Conditional注解的条件，进行自动配置并将Bean注入Spring Context

事务：使用事务注解@Transactional 之前，应该先了解它的相关属性，避免在实际项目中踩中各种各样的坑点。
常见坑点1：遇到非检测异常时，事务不开启，也无法回滚。

注解里使用rollbackFor 属性明确指定异常
  解决=@Transactional(rollbackFor = Exception.class)

常见坑点2： 在业务层捕捉异常后，发现事务不生效。
推荐做法：在业务层统一抛出异常，然后在控制层统一处理。


