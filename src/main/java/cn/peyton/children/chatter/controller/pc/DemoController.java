package cn.peyton.children.chatter.controller.pc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.controller.pc.DemoController
 * @date 2023年10月12日 22:44
 * @version 1.0.0
 * </pre>
 */
@Slf4j
@RestController
public class DemoController {

    @GetMapping("/test/{stuNo}")
    public String get(@PathVariable String stuNo) {
        return "测试数据"+ stuNo;
    }
}
