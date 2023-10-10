## Thymeleaf语法

### java url 写法

```java
@PostMapping("/topic/search/{keyword}/{pageNo}")
	public JSONResult<List<TopicParam>> search(
			@NotBlank(message = "搜索字段不能为空！") String keyword,
			@Min(value = 1,message = "要大于0的数！")
			Integer pageNo){

		return JSONResult.success(topicService.search(keyword,new PageQuery(pageNo)));
	}
```





####		标准表达式语法

#### 	th属性

```htm
片段包含： th:insert | th:replace
遍历：		th:each
条件判断:	th:if | th:unless | th:switch | th:case
声明变更：	th:object | th:with
任意属性修改：	th:attr | th:attrprepend | th:attrappend
修改指定属性默认值：	th:value | th:href | th:src ...
修改标签体内容:	th:text | th:utext
声明片段:	th:fragment
			th:remove
```

#### SpringBoot自动配置Thymeleaf的自动配置规则类,就不需要在配置 .yml 文件

```java
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {
 
	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;
 
	public static final String DEFAULT_PREFIX = "classpath:/templates/";
 
	public static final String DEFAULT_SUFFIX = ".html";
 
	private boolean checkTemplate = true;
	private boolean checkTemplateLocation = true;
	private String prefix = DEFAULT_PREFIX;
	private String suffix = DEFAULT_SUFFIX;
	private String mode = "HTML";
	private Charset encoding = DEFAULT_ENCODING;
}
```



### th的常用属性值

一、th:text ：设置当前元素的文本内容，相同功能的还有th:utext，两者的区别在于前者不会转义html标签，后者会。优先级不高：order=7

二、th:value：设置当前元素的value值，类似修改指定属性的还有th:src，th:href。优先级不高：order=6

三、th:each：遍历循环元素，和th:text或th:value一起使用。注意该属性修饰的标签位置，详细往后看。优先级很高：order=2

四、th:if：条件判断，类似的还有th:unless，th:switch，th:case。优先级较高：order=3

五、th:insert：代码块引入，类似的还有th:replace，th:include，三者的区别较大，若使用不恰当会破坏html结构，常用于公共代码块提取的场景。优先级最高：order=1

六、th:fragment：定义代码块，方便被th:insert引用。优先级最低：order=8

七、th:object：声明变量，一般和*{}一起配合使用，达到偷懒的效果。优先级一般：order=4

八、th:attr：修改任意属性，实际开发中用的较少，因为有丰富的其他th属性帮忙，类似的还有th:attrappend，th:attrprepend。优先级一般：order=5

### Thymeleaf 内置对象

- #dates：负责处理日期格式化的内置对象，具体用法可参考Date、DateFormat等类。
- #calendars：类似于#dates，只是功能类似于java.util.Calendar类。
- #numbers：负责数字格式化的内置对象。
- #strings：负责字符串格式化的内置对象，具体用法可参考java.lang.String等类。
- #objects：具体用法可参考java.lang.Object类。
- #bools：负责处理boolean类型的内置对象。
- #arrays：负责操作数组的内置对象，具体用法可参考java.util.Arrays类。
- #lists：负责操作列表的内置对象，具体用法可参考java.util.List类。
- #sets：负责操作Set的内置对象，具体用法可参考java.util.Set类。
- #maps：负责操作Map的内置对象，具体用法可参考java.util.Map类。
- #aggregates：负责对集合和数组执行聚集运算的内置对象。
- #messages：负责处理消息的内置对象





	#### 1、标准表达式

Thymeleaf 模板引擎支持多种表达式：

- 变量表达式：${…}

- 选择变量表达式：*{…}
- 链接表达式：@{…}
- 国际化表达式：#{…}
- 片段引用表达式：~{…}

##### 1.1 、变量表达式：${…}

（1）获取对象的属性和方法
 使用变量表达式可以获取对象的属性和方法。例如，获取 person 对象的 lastName 属性，表达式形式如下：

```java
${person.lastName}
```


（2）使用内置的基本对象
 使用变量表达式还可以使用内置基本对象，获取内置对象的属性，调用内置对象的方法。Thymeleaf中常用的内置基本对象如下：

- ​	#ctx ：上下文对象；
- ​	#vars ：上下文变量；
- ​	#locale：上下文的语言环境；
- ​	#request：HttpServletRequest 对象（仅在 Web 应用中可用）；
- ​	#response：HttpServletResponse 对象（仅在 Web 应用中可用）；
- ​	#session：HttpSession 对象（仅在 Web 应用中可用）；
- ​	#servletContext：ServletContext 对象（仅在 Web 应用中可用）。

我们通过以下 2 种形式，都可以获取到 session 对象中的 map 属性：

```java
${#session.getAttribute('map')}
${session.map}
```

（3）使用内置的工具对象
 除了能使用内置的基本对象外，变量表达式还可以使用一些内置的工具对象。

- ​	strings：字符串工具对象，常用方法有：equals、equalsIgnoreCase、length、replace、startsWith、endsWith，contains 和 containsIgnoreCase 等；
- ​	numbers：数字工具对象，常用的方法有：formatDecimal 等；
- ​	bools：布尔工具对象，常用的方法有：isTrue 和 isFalse 等；
- ​	arrays：数组工具对象，常用的方法有：toArray、length、isEmpty、contains 和 containsAll 等；
- ​	lists/sets：List/Set 集合工具对象，常用的方法有：toList、size、isEmpty、contains、containsAll 和 sort 等；
- ​	maps：Map 集合工具对象，常用的方法有：size、isEmpty、containsKey 和 containsValue 等；
- ​	dates：日期工具对象，常用的方法有：format、year、month、hour 和 createNow 等。

 我们可以使用内置工具对象 strings 的 equals 方法，来判断字符串与对象的某个属性是否相等，代码如下。

```java
${#strings.equals('why',name)}
```



##### 1.2、选择变量表达式：*{…}

 选择变量表达式与变量表达式功能基本一致，只是在变量表达式的基础上增加了与 th:object 的配合使用。

 当使用 th:object 存储一个对象后，我们可以在其后代中使用选择变量表达式（*{…}）获取该对象中的属性，其中，“**”即代表该对象。
```html
<div th:object="${session.user}" >
    <p th:text="*{fisrtName}">firstname</p>
</div>
```

th:object 用于存储一个临时变量，该变量只在该标签及其后代中有效。

##### 1.3、链接表达式：@{…}

无论是静态资源的引用，还是 form 表单的请求，凡是链接都可以用链接表达式 （@{…}）。

```html
无参请求：
<a href="http://www.baidu.com">传统写法:跳转至百度</a><br/>
<a th:href="@{http://www.baidu.com}">路径表达式:跳转至百度</a><br/>//绝对路径
<a th:href="@{/user/detail1}">跳转至:/user/detail1</a><br/>//相对路径

有参请求：
<a href="http://localhost:8080/test?username='zhangsan'">传统写法,带参数:/test,并带参数username</a><br/>
<a th:href="@{http://localhost:8080/test?username=zhangsan}">路径表达式写法,带参数:/test,并带参数username</a><br/>//绝对路径
<a th:href="@{/test?username=lisi}">相对路径,带参数</a>//相对路径
```

##### 1.4、国际化表达式：#{…}

该表达式称之为消息表达式，消息表达式主要用于从消息源中提取消息内容实现国际化。

```html
<p th:utext="#{home.welcome}">Hello,World!</p>
```

##### 1.5、片段引用表达式：~{…}

片段引用表达式用于在模板页面中引用其他的模板片段。

- ~{templatename::fragmentname}
- ~{templatename::#id}

以上语法结构说明如下：

- templatename：模版名，Thymeleaf 会根据模版名解析完整路径：/resources/templates/templatename.html，要注意文件的路径。
- fragmentname：片段名，Thymeleaf 通过 th:fragment 声明定义代码块，即：th:fragment=“fragmentname”
- id：HTML 的 id 选择器，使用时要在前面加上 # 号，不支持 class 选择器。

#### 2、th属性





属性	描述

- th:action	定义后台控制器的路径，类似标签的 action 属性，主要结合 URL 表达式,获取动态变量
- th:id	类似 html 标签中的 id 属性
- th:text	文本替换，转义特殊字符
- th:utext	文本替换，不转义特殊字符
- th:object	在父标签选择对象，子标签使用 *{…} 选择表达式选取值。没有选择对象，那子标签使用选择表达式和 ${…} 变量表达式是一样的效果。
- th:value	替换 value 属性
- th:name	设置名称
- th:src	替换 HTML 中的 src 属性
- th:each	遍历，支持 Iterable、Map、数组等。
- th:style	设置样式
- th:onclick	点击事件
- th:with	局部变量赋值运算
- th:if	根据条件判断是否需要展示此标签
- th:insert	布局标签；将使用 th:fragment 属性指定的模板片段（包含标签）插入到当前标签中
- th:inline	内联属性；该属性有 text，none,javascript 三种取值，



### 二、使用Thymeleaf模板进行数据交互

#### 1、Thymeleaf打印对象属性

##### 	1.1、新建一个实体bean User

```java
public class User {
	private Integer id;
	private String name;
	private int age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
```



##### 1.2、新建Controller

```java
@Controller
public class SecondThymeleafController {
	@GetMapping("/second")
	public String indexPage(Model model) {
		String message = "Hello, Thymeleaf!";
		User u = new User();
		u.setId(1);
		u.setName("why");
		u.setAge(18);
    
		Map<String,Object> map=new HashMap<>();
		map.put("src1","1.jpg");
		map.put("src2","2.jpg");
		model.addAttribute("message", message);
		model.addAttribute("user", u);
		model.addAttribute("src", map);
		return "index2";
	}
}
```

##### 1.3、在resource/templates下，新增模板文件index2.html

```html
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>首页</title>
</head>
<body>
	<h1 th:text="${message}"></h1>
	<img th:src="${src.src1}"/>
	</br>
	<img th:src="${src.src2}"/>
	</br>
	<span th:text="${user.id}"></span>
	<span th:text="${user.name}"></span>
	<span th:text="${user.age}"></span>
</body>
</html>
```

##### 1.4、访问地址http://localhost:8080/second



#### 2、Thymeleaf循环遍历集合

##### 2.1、新建一个Controller

```java
@Controller
public class ThreeThymeleafController {
	@GetMapping("/three")
	public String indexPage(Model model) {
		List<User> list=new ArrayList<User>();
		User u1 = new User();
		u1.setId(1);
		u1.setName("张三");
		u1.setAge(18);
		list.add(u1);
        
		User u2 = new User();
		u2.setId(2);
		u2.setName("李四");
		u2.setAge(28);
		list.add(u2);
        
		User u3 = new User();	
		u3.setId(3);
		u3.setName("王五");
		u3.setAge(25);
        list.add(u3);
        
        User u4 = new User();
		u4.setId(4);
		u4.setName("麻子");
		u4.setAge(888);
		list.add(u4);
        
        model.addAttribute("userList", list);
        return "index3";
	}
}
```

##### 2.2、在resource/templates下，新增模板文件index3.html

```html
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>首页</title>
</head>
<body>
  <table width="200" style="text-align: center;">
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>index</th>
	</tr>
	<tr th:each="user,iterStat : ${userList}">
		<td th:text="${user.id}"></td>
		<td th:text="${user.name}"></td>
		<td th:text="${user.age}"></td>
		<td th:text="${iterStat.index}">index</td>
	</tr>
  </table>
</body>
</html>
```

##### 2.3、访问地址http://localhost:8080/three

#### 3、Thymeleaf赋值、字符串拼接

##### 3.1、新建一个Controller

```java
@Controller
public class FourThymeleafController {
	@GetMapping("/four")
	public String indexPage(Model model) {
		model.addAttribute("userName", 互联网底层民工");
		model.addAttribute("href", "https://blog.csdn.net/m0_67296957");
		return "index4";
	}
}
```

##### 3.2、在resource/templates下，新增模板文件index4.html

```html
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>首页</title>
</head>
<body>
<!-- 给标签赋值 th:text -->
	<h1 th:text="${userName}"></h1>
<!-- 给属性赋值 th:value、th:属性名称 -->
	<input type="text" name="names" th:value="${userName}"/>
	</br>
	<em th:size="${userName}"></em>
<!-- 字符串拼接 -->
	<span th:text="'欢迎来:'+${userName}+'学习!'"></span>
	</br>
<!-- 字符串拼接,方式2 -->
	<span th:text="|欢迎来:${userName}学习!|"></span>
</body>
</html>
```

##### 3.3、访问地址http://localhost:8080/four



#### 4、Thymeleaf条件判断、选择语句

##### 4.1、新建一个Controller

```java
@Controller
public class FiveThymeleafController {
	@GetMapping("/five")
	public String indexPage(Model model) {
		model.addAttribute("flag", "yes");
		model.addAttribute("menu", "admin");
		model.addAttribute("manager", "manager");
		return "index5";
	}
}
```

##### 4.2、在resource/templates下,新增模板文件index5.html

```html
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
	</head>
	<body>
		<!-- th:if 条件成立就显示 -->
		<h1 th:if="${flag=='yes'}" >互联网底层民工</h1>
		<!-- th:unless 条件不成立就显示 -->
		<h1 th:unless="${flag=='no'}" >why</h1>
		<!-- switch选择语句 -->
		<div th:switch="${menu}">
			<p th:case="'admin'">User is an administrator</p>
			<p th:case="${manager}">User is a manager</p>
		</div>
	</body>
</html>
```

##### 4.3、访问地址http://localhost:8080/five



#### 5、Thymeleaf静态资源加载

如果我们让IDE识别 .css文件，那么我们要用相对路径来引入这个文件。如果我们想要在发布后服务器能够加载这个文件，我们就必须用相对于resources或static的位置来引入静态文件。

显然，一般情况下我们不能兼顾这两个问题，只能要么在编写的时候用相对自己的路径，然后在发布的时候用相对于项目资源文件夹的路径，要么就只能放弃IDE的提示，非常尴尬。

而在Thymeleaf中，我们可很好的处理这一点。在引入资源的时候，我们可以写类似下面的代码:
```javascript
<link rel="stylesheet" type="text/css" media="all" href="../../css/gtvg.css" th:href="@{/css/gtvg.css}" />
```

当我们在没有后台渲染的情况下，浏览器会认得href，但是不认得th:href，这样它就会选择以相对与本文件的相对路径去加载静态文件。而且我们的IDE也能识别这样的加载方式，从而给我们提示。

当我们在有后台渲染的情况下，后台会把这个标签渲染为这样:

```javascript
<link rel="stylesheet" type="text/css" media="all" href="/css/gtvg.css" />
```



#### 6、Thymeleaf片段fragment定义使用

fragment类似于JSP的tag，在html中文件中，可以将多个地方出现的元素块用fragment包起来使用。

**定义fragment,**所有的fragment可以写在一个文件里面，也可以单独存在，例如：

##### 6.1、在resource/templates下，新增模板文件footer.html

```hmtl
<body>
    <h1 th:fragment="copy">
		&copy; 1999-2022 Offcn.All Rights Reserved
	</h1>
</body>
```

注意： 在Springboot中，默认读取thymeleaf文件的路径是：src/main/resource/templates

##### 6.2、编写Controller

```java
@Controller
public class SixThymeleafController {
	@GetMapping("/six")
	public String indexPage(Model model) {
		return "index6";
	}
}
```

##### 6.3、 在resource/templates下，新增视图文件index6.html

```html
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
	</head>
	<body>
		<!-- 把片段的内容插入到当前位置 -->
		<div style="color: #82ff6c" th:insert="~{footer :: copy}"></div>
		</br>
		<!-- 使用片段的内容替换当前标签 -->
		<div style="color: #82ff6c" th:replace="~{footer :: copy}"></div>
		</br>
		<!-- 保留自己的主标签，不要片段的主标签 -->
		<div style="color: #82ff6c" th:include="~{footer :: copy}"></div>
	</body>
</html>
```

th:insert:保留自己的主标签，保留th:fragment的主标签。

th:replace:不要自己的主标签，保留th:fragment的主标签。

th:include:保留自己的主标签，不要th:fragment的主标签。

##### 6.4、访问地址http://localhost:8080/six运行



#### 7、Thymeleaf表达式内置对象使用

##### 7.1、常见内置工具：

- \#dates：与java.util.Data对象的方法对应，格式化、日期组件抽取等等
- \#numbers：格式化数字对象的工具方法
- \#strings：与java.lang.String对应的工具方法

##### 7.2、编写Controller

```java
@Controller
public class SevenThymeleafController {
	@GetMapping("/seven")
	public String indexPage(Model model) {
		//日期时间
		Date date = new Date();
		model.addAttribute("date", date);
		//小数的金额
		double price=128.5678D;
		model.addAttribute("price", price);
		//定义大文本数据
		String str="Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。\r\n" +
		"Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。\r\n" +
		"Thymeleaf也从一开始就设计了Web标准 - 特别是HTML5 - 允许您创建完全验证的模板，如果这是您需要的\r\n" ;
		model.addAttribute("strText", str);

  	  //定义字符串
  	    String str2="JAVA-why";
		model.addAttribute("str2", str2);
		return "index7";
	}
}
```

##### 7.3、在resource/templates下，新增视图文件index7.html

```html
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>首页</title>
</head>
<body>
时间：<span th:text="${#dates.format(date,'yyyy-MM-dd HH:mm:ss')}">4564546</span>
</br>
金额：<span th:text="'￥'+${#numbers.formatDecimal(price, 1, 2)}">180</span> </br>
<!-- # 这里的含义是 如果 atc.text 这个变量多余60个字符，后面显示... -->
<p th:text="${#strings.abbreviate(strText,60)}">内容内容内容</p>

<!-- 判断字符串是否为空 -->
<span th:if="${!#strings.isEmpty(str2)}">字符串str2不为空</span></br>
<!-- 截取字符串，指定长度 -->
<span th:text="${#strings.substring(str2,0,4)}">字符串str2的值</span>
</body>
</html>
```

##### 7.4、运行访问地址http://localhost:8080/seven

-----------------------------------------------------------------------------------------------------------------------------------------------------------


