package cr.service;

import cr.model.News;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 小富 on 2018/1/23.
 */

public interface NewService {
    public List<News> queryByType(String type);
}
