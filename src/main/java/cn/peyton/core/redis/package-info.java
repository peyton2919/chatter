/**
 * <h3>redis 包</h3>
 * <pre>
 *     1. redis 配置密码 获取密码: config get requirepass 设置密码: config set requirepass 密码 auth 密码
 *     2. 关于配置文件中的注解：
 *          1). @Configuration 在整个RedisConfig文件的上文，可理解为用spring的时候xml里面的标签
 *              底层是含有@Component ，所以@Configuration 具有和 @Component 的作用。
 *               注：配置类必须以类的形式提供（不能是工厂方法返回的实例），允许通过生成子类在运行时增强（cglib 动态代理）。
 *                  配置类不能是 final 类（没法动态代理）。 配置注解通常为了通过 @Bean 注解生成 Spring 容器管理的类。
 *                  配置类必须是非本地的（即不能在方法中声明，不能是 private）。 任何嵌套配置类都必须声明为static。
 *                  @Bean方法不能创建进一步的配置类（也就是返回的bean如果带有@Configuration，也不会被特殊处理，只会作为普通的 bean）。
 *           2). @EnableCaching 注解是spring framework中的注解驱动的缓存管理功能。自spring版本3.1起加入了该注解。
 *              如果你使用了这个注解，那么你就不需要在XML文件中配置cache manager了。
 *              当你在配置类(@Configuration)上使用@EnableCaching注解时，会触发一个post processor，这会扫描每一个spring bean，
 *              查看是否已经存在注解对应的缓存。如果找到了，就会自动创建一个代理拦截方法调用，使用缓存的bean执行处理。
 *           3). @Bean 可理解为用spring的时候xml里面的标签。
 *              注： @Bean注解在返回实例的方法上，如果未通过@Bean指定bean的名称，则默认与标注的方法名相同；
 *                  @Bean注解默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为原型作用域；
 *                  既然@Bean的作用是注册bean对象，那么完全可以使用@Component、@Controller、@Service、@Repository
 *                  等注解注册bean（在需要注册的类上加注解），当然需要配置@ComponentScan注解进行自动扫描。
 *     3. 使用注解开发：
 *          1). @Cacheable 作用是主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 *              例如：// @Cacheable(value = "plum-redis-cache1",key = "'book'+#bid",condition = "#bid>10")
 *              public Book selectByPrimaryKey(Integer bid) { return bookMapper.selectByPrimaryKey(bid); }
 *              参数说明：
 *                  value ： 缓存的名称，在 spring 配置文件中定义，必须指定至少一个，
 *                  key ：缓存的 key，可以为空， 如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合，
 *                      例如：@Cacheable(value=”my-redis-cache1”,key=”#bookName”)。
 *                  condition ：缓存的条件，可以为空， 使用 SpEL 编写，返回 true 或者 false， 只有为 true 才进行缓存，
 *                      例如：@Cacheable(value=”my-redis-cache1”,condition=“#bid>10”）
 *          2). @CachePut 只存不读 每次都真实查询数据库，把数据带到内存来; 作用是主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和
 *                  @Cacheable 不同的是，它每次都会触发真实 方法的调用 主要参数说明： @Cacheable一样。
 *          3). @CacheEvict： 作用是主要针对方法配置，能够根据一定的条件对缓存进行清空
 *              参数说明：
 *                  allEntries ： 是否清空所有缓存内容，缺省为 false， 如果指定为 true，则方法调用后将立即清空所有缓存，
 *                      例如：@CachEvict(value=”testcache”,allEntries=true)。
 *                  beforeInvocation ： 是否在方法执行前就清空，缺省为 false， 如果指定为 true，则在方法还没有执行的时候就清空缓存，
 *                      缺省情况下，如果方法执行抛出异常，则不会清空缓存， 例如@CachEvict(value=”testcache”，beforeInvocation=true)。
*                   例如：
 *                      @CacheEvict(value = "plum-redis-cache2",allEntries =true) public void clear(){ System.out.println("my-redis-cache2清除成功"); }
 *                      附：@Cacheable是想缓存中添加数据， @CachePut 更新缓存中的数据， @@CacheEvict是删除缓存中的数据
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
 */
package cn.peyton.core.redis;