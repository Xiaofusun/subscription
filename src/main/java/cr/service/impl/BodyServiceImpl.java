package cr.service.impl;

import cr.model.Body;
import cr.model.News;
import cr.model.mapper.BodyMapper;
import cr.model.mapper.NewsMapper;
import cr.service.BodyService;
import cr.service.NewService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 小富 on 2018/1/23.
 */
@Service
public class BodyServiceImpl implements BodyService {
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession=null;
    Body body =null;
    public Body getById(int id) {

        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.commit();
            body =sqlSession.getMapper(BodyMapper.class).getById(id);
        }catch (Exception e){
            throw new RuntimeException("查找错误");
        }finally {
            sqlSession.close();
        }
        return body;
    }
}
