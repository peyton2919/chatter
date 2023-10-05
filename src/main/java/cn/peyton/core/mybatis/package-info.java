/**
 * <h3></h3>
 * <pre>
 *     一、mybatis 查询:
 *       1. 模糊查询 like SELECT * FROM 表名 WHERE 字段名 like CONCAT('%',#{属性值},'%')
 *       2. if 用法 SELECT * FROM 表名 WHERE 1 = 1 AND name= #{name} AND author_name like #{author.name}
 *       3. choose, when, otherwise choose 元素，它有点像 Java 中的 switch 语句。
 *              提供了"title"就按"title"查找，提供了"author"就按"author"查找，若两者都没有提供，
 *              就返回所有符合条件的BLOG SELECT * FROM 表名 WHERE state = ‘ACTIVE’ AND title like #{title} AND author_name like #{author.name} AND featured = 1
 *       4. where 元素知道只有在一个以上的if条件有值的情况下才去插入"WHERE"子句。
 *              而且，若最后的内容是"AND"或"OR"开头的，where 元素也知道如何将他们去除。
 *              SELECT * FROM 表名 state = #{state} AND title like #{title} AND author_name like #{author.name}
 *       5. trim prefixOverrides 属性会忽略通过管道分隔的文本序列（注意此例中的空格也是必要的）。
 *              它带来的结果就是所有在 prefixOverrides 属性中指定的内容将被移除，
 *              并且插入 prefix 属性中指定的内容 select * from emp e and e.ename like #{ename} and e.sal > #{sal}
 *              and e.empno in <foreach collection="empnoList" item="empno" open="(" close=")" separator=", " index="a"> #{empno}
 *       6. set 元素会动态前置 SET 关键字，同时也会消除无关的逗号，因为用了条件语句之后很可能就会在生成的赋值语句的后面留下这些逗号。
 *              update emp e e.ename=#{ename}, e.job=#{job}, e.mgr=#{mgr}, e.hiredate=#{hiredate}, e.sal=#{sal}, e.comm=#{comm}, e.empno=#{empno}
 *       7. foreach 动态 SQL 的另外一个常用的必要操作是需要对一个集合进行遍历，通常是在构建 IN 条件语句的时候。 SELECT * FROM POST P WHERE ID in #{item}
 *
 *     二、日期查询:
 *      1. 查询当天的数据 SELECT * FROM 表 WHERE date(时间字段名) = curdate();
 *      2. 当月的数据 SELECT *FROM 表 WHERE DATE_FORMAT(时间字段名,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m');
 *      3. 查询昨天的数据(含今天的数据) SELECT * FROM 表名 WHERE TO_DAYS(NOW()) - TO_DAYS(时间字段名) <= 1
 *      4. 查询昨天的数据 SELECT * FROM 表名 WHERE TO_DAYS(NOW()) - TO_DAYS(时间字段名) <= 1 AND TO_DAYS(NOW()) - TO_DAYS(时间字段名) >= 1
 *      5. 查询前天的数据(以此类推改相应的数字) SELECT * FROM 表名 WHERE TO_DAYS(NOW()) - TO_DAYS(时间字段名) <= 2 AND TO_DAYS(NOW()) - TO_DAYS(时间字段名) >= 2
 *      6. 查询7天的数据 SELECT * FROM 表名 where DATE_SUB(CURDATE(), INTERVAL 7 DAY) < date(时间字段名)
 *      7. 查询近30天的数据 SELECT * FROM 表名 where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(时间字段名)
 *      8. 查询本月的数据 SELECT * FROM 表名 WHERE DATE_FORMAT(时间字段名, '%Y%m' ) = DATE_FORMAT(CURDATE() , '%Y%m')
 *      9. 上个月的数据 (数据1表示上个月,以此类推2表示上上个月) SELECT * FROM 表名 WHERE PERIOD_DIFF(date_format(now() , '%Y%m') , date_format(时间字段名, '%Y%m' ) ) =1
 *      10. 本季度的数据 select * from 表名 where QUARTER(时间字段名)=QUARTER(now());
 *      11. 上季度的数据 select * from 表名 where QUARTER(时间字段名)=QUARTER(DATE_SUB(now(),interval 1 QUARTER));
 *      12. 查询本年的数据 select * from 表名 where YEAR(时间字段名)=YEAR(NOW());
 *      13. 查询上年的数据 select * from 表名 where year(时间字段名)=year(date_sub(now(),interval 1 year));
 *      14. 查询当前这周的数据 SELECT * FROM 表名 WHERE YEARWEEK(date_format(时间字段名,'%Y-%m-%d')) = YEARWEEK(now());
 *      15. 查询上周的数据 SELECT * FROM 表名 WHERE YEARWEEK(date_format(时间字段名,'%Y-%m-%d')) = YEARWEEK(now())-1;
 *      16. 查询当月的数据 select * from 表名 where date_format(时间字段名,'%Y-%m')=date_format(now(),'%Y-%m')
 *      17. 查询距离当前现在6个月的数据 select * from 表名 where 时间字段名 between date_sub(now(),interval 6 month) and now();
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
 */
package cn.peyton.core.mybatis;