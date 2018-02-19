import cr.model.Body;
import cr.model.Testuser;

import cr.model.mapper.BodyMapper;
import cr.model.mapper.TestUserMapper;
import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
            sqlSession= factory.openSession();
            conut = sqlSession.getMapper(TestUserMapper.class).conut();
            logger.debug("count test++++++++>>>" + conut);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           sqlSession.close();
        }
    }
   @Test
    public void addUser() {
        String resources = "mybatis-config.xml";
        int conut = 0;
        InputStream is = null;
        SqlSession sqlSession = null;
        SqlSessionFactory factory = null;
        try {
            is = Resources.getResourceAsStream(resources);
            factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession(false);
           Testuser user =new Testuser();
            user.setId(8);
            user.setAge(21);
            user.setUser_name("猴子");
           //= sqlSession.insert("cr.service.testUserMapper.addUser",user );
            conut =sqlSession.getMapper(TestUserMapper.class).addUser(user);

            logger.debug("insert test++++++++>>>" + conut);
            sqlSession.commit();
        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selcetUserTest() {
        String resources = "mybatis-config.xml";

        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream(resources);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession= factory.openSession();
            List<Testuser> users = sqlSession.getMapper(TestUserMapper.class).userList();
            for (Testuser u:users){
                //控制台输出
                System.out.println(u);
            }
            logger.debug("selcetUser test++++++++>>>" );

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void bodyTest() {
        String resources = "mybatis-config.xml";

        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream(resources);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession= factory.openSession();
            Body body = sqlSession.getMapper(BodyMapper.class).getById(3);

                System.out.println(body);

            logger.debug("selcetUser test++++++++>>>" );

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
