import cr.model.Body;
import cr.model.News;
import cr.model.Testuser;
import cr.service.BodyService;
import cr.service.NewService;
import cr.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 小富 on 2018/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceTest {
    @Resource
    private NewService newService;
    @Resource
    private BodyService bodyService;
    @Resource
    private TestService testService;
    @Test
    public void queryByType(){
        List<News> list=newService.queryByType("国内新闻");
    //控制台输出
        for (News l:list){
            System.out.println(l.toString());
        }
    }
    @Test
    public void getById(){
        Body body=bodyService.getById(3);
    //控制台输出
    System.out.println(body);
    }
    @Test
    public void userList(){
        List<Testuser> list=testService.userList();
        for (Testuser user:list){
            //控制台输出
            System.out.println(user);
        }
    }
}
