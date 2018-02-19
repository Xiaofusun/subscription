package cr.service.impl;

import cr.model.Testuser;
import cr.model.mapper.TestUserMapper;
import cr.service.TestService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 小富 on 2018/1/23.
 */
@Service
public class TestServiceImpl implements TestService{
        @Resource
        private SqlSessionFactory sqlSessionFactory;
        SqlSession sqlSession=null;
        List<Testuser> userList=null;
        public List<Testuser> userList() {
                try {
                        sqlSession = sqlSessionFactory.openSession();
                        sqlSession.commit();
                        userList =sqlSession.getMapper(TestUserMapper.class).userList();
                }catch (Exception e){
                        throw new RuntimeException("查找错误");
                }finally {
                        sqlSession.close();
                }
                return userList;
        }

}
