import cr.model.Testuser;
import cr.model.mapper.NewsMapper;
import cr.model.mapper.TestUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 小富 on 2018/1/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class springTest {
    @Resource
    private Date date;
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    @Test
    public void showTest(){
        //控制台输出
        System.out.println(date);
    }
@Test
    public void testSqlSession(){
         SqlSession sqlSession=sqlSessionFactory.openSession();
        List<Testuser> users = sqlSession.getMapper(TestUserMapper.class).userList();
        for (Testuser u:users){
            //控制台输出
            System.out.println(u);
        }sqlSession.getMapper(NewsMapper.class).listNews();
    }

}
