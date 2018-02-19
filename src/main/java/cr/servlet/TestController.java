package cr.servlet;

import cr.model.Testuser;
import cr.service.TestService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 小富 on 2018/1/24.
 */
@Component
@RequestMapping("/test.do")
public class TestController {
    @Resource
    private TestService testService;
@RequestMapping(params ="method=res")
    public String res(int id){
    System.out.println(id);

        System.out.println("测试成功");
        return "test";
    }
}
