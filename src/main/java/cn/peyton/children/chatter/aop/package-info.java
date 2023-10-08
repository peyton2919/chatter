/**
 * <h3>aop 切面包</h3>
 * <pre>
 *      @Aspect -- 作用是把当前类标识为一个切面供容器读取
 *      @Pointcut -- (切入点):就是带有通知的连接点，在程序中主要体现为书写切入点表达式
 *      @Before -- 标识一个前置增强方法，相当于BeforeAdvice的功能
 *      @AfterReturning -- 后置增强，相当于AfterReturningAdvice，方法退出时执行
 *      @AfterThrowing -- 异常抛出增强，相当于ThrowsAdvice
 *      @After -- final增强，不管是抛出异常或者正常退出都会执行
 *      @Around -- 环绕增强，相当于MethodInterceptor
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
 */
package cn.peyton.children.chatter.aop;
/**
 *
 * 前置通知
 *
 * 后置通知
 * 异常通知
 * 最终通知
 * 环绕通知
 ------>------>------>------>------>------>------>------>------>------>------>------>------
 * 第一种：
 @Aspect
 @Component
 public class LogApsect {

     private static final Logger logger = LoggerFactory.getLogger(LogApsect.class);
     ThreadLocal<Long> startTime = new ThreadLocal<>();
     // 第一个*代表返回类型不限
     // 第二个*代表所有类
     // 第三个*代表所有方法
     // (..) 代表参数不限
     @Pointcut("execution(public * cn.peyton.child.chatter.controller.*.*(..))")
     @Order(2)
     public void pointCut(){};

     @Pointcut("@annotation(cn.peyton.child.chatter.annotation.RedisCache)")
     @Order(1) // Order 代表优先级，数字越小优先级越高
     public void annoationPoint(){};

     @Before(value = "annoationPoint() || pointCut()")
     public void before(JoinPoint joinPoint){
         System.out.println("方法执行前执行......before");
         ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();
         logger.info("<=====================================================");
         logger.info("请求来源： =》" + request.getRemoteAddr());
         logger.info("请求URL：" + request.getRequestURL().toString());
         logger.info("请求方式：" + request.getMethod());
         logger.info("响应方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
         logger.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
         logger.info("------------------------------------------------------");
         startTime.set(System.currentTimeMillis());
     }

     // 定义需要匹配的切点表达式，同时需要匹配参数
     @Around("pointCut() && args(arg)")
     public Response around(ProceedingJoinPoint pjp,String arg) throws Throwable{
         System.out.println("name:" + arg);
         System.out.println("方法环绕start...around");
         String result = null;
         try{
             result = pjp.proceed().toString() + "aop String";
             System.out.println(result);
         }catch (Throwable e){
            e.printStackTrace();
         }
         System.out.println("方法环绕end...around");
         return (Response) pjp.proceed();
     }

     @After("within(cn.peyton.child.chatter.controller.*Controller)")
     public void after(){
        System.out.println("方法之后执行...after.");
     }

     @AfterReturning(pointcut="pointCut()",returning = "rst")
     public void afterRunning(Response rst){
         if(startTime.get() == null){
            startTime.set(System.currentTimeMillis());
         }
         System.out.println("方法执行完执行...afterRunning");
         logger.info("耗时（毫秒）：" + (System.currentTimeMillis() - startTime.get()));
         logger.info("返回数据：{}", rst);
         logger.info("==========================================>");
     }

     @AfterThrowing("within(cn.peyton.child.chatter.controller.*Controller)")
     public void afterThrowing(){
        System.out.println("异常出现之后...afterThrowing");
     }
 }
 ------>------>------>------>------>------>------>------>------>------>------>------>------

 * 第二种
 @Before是在方法执行前的无法终止原方法执行,你用@Around这个是环绕通知.
 @Around("拦截表达式")
 public Object around(ProceedingJoinPoint pjp){
     if(validation()){//你的校验成功执行方法,失败方法就不用执行了
        return pjp.proceed();
     }else{
        //可以返回你失败的信息也可以直接抛出校验失败的异常
     }
 }

------>------>------>------>------>------>------>------>------>------>------>------>------
  * 前置通知
  * @param joinPoint 该参数可以获取目标对象的信息,如类名称,方法参数,方法名称等
 @Before("execution(* cn.peyton.child.chatter.mapper.UserMapper.addUser(..))")
 public void before(JoinPoint joinPoint){
    System.out.println("我是前置通知");
 }

------>------>------>------>------>------>------>------>------>------>------>------>------
  * 后置通知，不需要参数时可以不提供
 @AfterReturning(value="execution(* cn.peyton.child.chatter.mapper.UserMapper.*User(..))")
 public void AfterReturning(){
    System.out.println("我是后置通知...");
 }

  * 后置通知
  * returnVal,切点方法执行后的返回值
 @AfterReturning(value="execution(* cn.peyton.child.chatter.mapper.UserMapper.*User(..))",returning = "returnVal")
 public void AfterReturning(JoinPoint joinPoint,Object returnVal){
    System.out.println("我是后置通知...returnVal+"+returnVal);
 }

------>------>------>------>------>------>------>------>------>------>------>------>------
  * 抛出通知
  * @param e 抛出异常的信息
 @AfterThrowing(value="execution(* cn.peyton.child.chatter.mapper.UserMapper.addUser(..))",throwing = "e")
 public void afterThrowable(Throwable e){
    System.out.println("出现异常:msg="+e.getMessage());
 }

------>------>------>------>------>------>------>------>------>------>------>------>------
  * 无论什么情况下都会执行的方法
  * joinPoint 参数
 @After("execution(* cn.peyton.child.chatter.mapper.UserMapper.*User(..))")
 public void after(JoinPoint joinPoint) {
    System.out.println("最终通知....");
 }

------>------>------>------>------>------>------>------>------>------>------>------>------
 环绕通知既可以在目标方法前执行也可在目标方法之后执行，更重要的是环绕通知可以控制目标方法是否指向执行，
 但即使如此，我们应该尽量以最简单的方式满足需求，在仅需在目标方法前执行时，应该采用前置通知而非环绕通知。
 案例代码如下第一个参数必须是ProceedingJoinPoint，通过该对象的proceed()方法来执行目标函数，proceed()的返回值就是环绕通知的返回值。
 同样的，ProceedingJoinPoint对象也是可以获取目标对象的信息,如类名称,方法参数,方法名称等等
 @Around("execution(* cn.peyton.child.chatter.mapper.UserMapper.*User(..))")
 public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
     System.out.println("我是环绕通知前....");
     //执行目标函数
     Object obj= (Object) joinPoint.proceed();
     System.out.println("我是环绕通知后....");
     return obj;
 }

------>------>------>------>------>------>------>------>------>------>------>------>------
 切点表达式示例：
 //任意返回值，任意名称，任意参数的公共方法
 execution(public * *(..))

 //匹配实现了DaoUser接口的所有子类的方法
 within(com.zejian.dao.DaoUser+)

 bean：Spring AOP扩展的，AspectJ没有对于指示符，用于匹配特定名称的Bean对象的执行方法；
 //匹配名称中带有后缀Service的Bean。
 @Pointcut("bean(*Service)")
 private void myPointcut1(){}

 this ：用于匹配当前AOP代理对象类型的执行方法；请注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配
 //匹配了任意实现了UserDao接口的代理对象的方法进行过滤
 @Pointcut("this(com.zejian.spring.springAop.dao.UserDao)")
 private void myPointcut2(){}

 target ：用于匹配当前目标对象类型的执行方法
 //匹配了任意实现了UserDao接口的目标对象的方法进行过滤
 @Pointcut("target(com.zejian.spring.springAop.dao.UserDao)")
 private void myPointcut3(){}

 @within：用于匹配所以持有指定注解类型内的方法；请注意与within是有区别的， within是用于匹配指定类型内的方法执行
 //匹配使用了MarkerAnnotation注解的类(注意是类)
 @Pointcut("@within(com.zejian.spring.annotation.MarkerAnnotation)")
 private void myPointcut4(){}

 @annotation(com.zejian.spring.MarkerMethodAnnotation) : 根据所应用的注解进行方法过滤
 //匹配使用了MarkerAnnotation注解的方法(注意是方法)
 @Pointcut("@annotation(com.zejian.spring.annotation.MarkerAnnotation)")
 private void myPointcut5(){}
 切点指示符可以使用运算符语法进行表达式的混编，如and、or、not（或者&&、||、！）

 //匹配了任意实现了UserDao接口的目标对象的方法并且该接口不在com.zejian.dao包及其子包下
 @Pointcut("target(com.zejian.spring.springAop.dao.UserDao) ！within(com.zejian.dao..*)")
 private void myPointcut6(){}

 //匹配了任意实现了UserDao接口的目标对象的方法并且该方法名称为addUser
 @Pointcut("target(com.zejian.spring.springAop.dao.UserDao)&&execution(* com.zejian.spring.springAop.dao.UserDao.addUser(..))")
 private void myPointcut7(){}
------>------>------>------>------>------>------>------>------>------>------>------>------
 within(<type name>)
 //匹配com.zejian.dao包及其子包中所有类中的所有方法
 @Pointcut("within(com.zejian.dao..*)")

 //匹配UserDaoImpl类中所有方法
 @Pointcut("within(com.zejian.dao.UserDaoImpl)")

 //匹配UserDaoImpl类及其子类中所有方法
 @Pointcut("within(com.zejian.dao.UserDaoImpl+)")

 //匹配所有实现UserDao接口的类的所有方法
 @Pointcut("within(com.zejian.dao.UserDao+)")

------>------>------>------>------>------>------>------>------>------>------>------>------
 语法格式如下：
 //scope ：方法作用域，如public,private,protect
 //returnt-type：方法返回值类型
 //fully-qualified-class-name：方法所在类的完全限定名称
 //parameters 方法参数
 execution(<scope> <return-type> <fully-qualified-class-name>.*(parameters))

 示例：
 //匹配UserDaoImpl类中的所有方法
 @Pointcut("execution(* com.zejian.dao.UserDaoImpl.*(..))")

 //匹配UserDaoImpl类中的所有公共的方法
 @Pointcut("execution(public * com.zejian.dao.UserDaoImpl.*(..))")

 //匹配UserDaoImpl类中的所有公共方法并且返回值为int类型
 @Pointcut("execution(public int com.zejian.dao.UserDaoImpl.*(..))")

 //匹配UserDaoImpl类中第一个参数为int类型的所有公共的方法
 @Pointcut("execution(public * com.zejian.dao.UserDaoImpl.*(int , ..))")
------>------>------>------>------>------>------>------>------>------>------>------>------
------>------>------>------>------>------>------>------>------>------>------>------>------
------>------>------>------>------>------>------>------>------>------>------>------>------
------>------>------>------>------>------>------>------>------>------>------>------>------
------>------>------>------>------>------>------>------>------>------>------>------>------
------>------>------>------>------>------>------>------>------>------>------>------>------
------>------>------>------>------>------>------>------>------>------>------>------>------
------>------>------>------>------>------>------>------>------>------>------>------>------


 */