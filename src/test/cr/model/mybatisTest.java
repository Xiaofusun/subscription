package cr.model;



import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 小富 on 2018/1/13.
 */
public class mybatisTest {
    private Logger logger = Logger.getLogger(mybatisTest.class);

    @Test
    public void conut() {
        String resources = "mybatis-config.xml";
        int conut = 0;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream(resources);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            conut = sqlSession.selectOne("cr.service.testUserMapper.conut");
            logger.debug("count test++++++++>>>" + conut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    /*@Test
    public void addUser() {
        String resources = "mybatis-config.xml";
        int conut = 0;
        InputStream is = null;
        SqlSession sqlSession = null;
        SqlSessionFactory factory = null;
        try {
            is = Resources.getResourceAsStream(resources);
            factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            TestUser user =new 
           // conut = sqlSession.insert("cr.service.testUserMapper.addUser", );
            logger.debug("insert test++++++++>>>" + conut);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }*/
}
