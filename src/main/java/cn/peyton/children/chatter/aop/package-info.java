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