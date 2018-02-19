import cr.model.News;
import cr.model.Testuser;
import cr.model.mapper.NewsMapper;
import cr.model.mapper.TestUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 小富 on 2018/1/15.
 */


public class newsTest {
    private Logger logger = Logger.getLogger(mybatisTest.class);
    @Test
    public void listNews(){
        String resources = "mybatis-config.xml";

        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream(resources);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession= factory.openSession();
            List<News> news = sqlSession.getMapper(NewsMapper.class).listNews();
            for (News n:news){
                //控制台输出
                System.out.println(n);
            }
            logger.debug("selcetNews test++++++++>>>" );

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    }



