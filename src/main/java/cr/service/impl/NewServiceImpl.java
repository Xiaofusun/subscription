package cr.service.impl;

import cr.model.News;
import cr.model.mapper.NewsMapper;
import cr.service.NewService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 小富 on 2018/1/23.
 */
@Service
public class NewServiceImpl implements NewService {
        @Resource
        private SqlSessionFactory sqlSessionFactory;
        public List<News> queryByType(String type) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List newss=sqlSession.getMapper(NewsMapper.class).queryByType(type);
        return newss;
    }
}
