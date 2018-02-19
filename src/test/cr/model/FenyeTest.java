import cr.model.News;
import cr.model.Page;
import cr.service.NewService;
import cr.util.ListPageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 小富 on 2018/1/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FenyeTest {
    @Resource
    private NewService newService;
    @Resource
    private ListPageUtil<News> listPageUtil;
    @Resource
    private Page<News> page;
    @Test
    public void main() {
        List<News> list = newService.queryByType("国内新闻");
        // ListPageUtil<Integer> pager = new ListPageUtil<Integer>(list, 10);
       page=listPageUtil.setListPage(list,1,10);
        List<News> lists=page.getPagedList();
       //控制台输出
       //System.out.println(listPageUtil.getNowPage());
       for (News n:lists){
        //控制台输出
        System.out.println(n);
    }
    }


}
