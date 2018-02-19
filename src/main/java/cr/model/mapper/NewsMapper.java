package cr.model.mapper;

import cr.model.News;

import java.util.List;

/**
 * Created by 小富 on 2018/1/15.
 */

public interface NewsMapper {

    //显示所有信息
    public List<News> listNews();

    //根据新闻类型查找新闻
    public List<News> queryByType(String type);
}
