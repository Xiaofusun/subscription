package cr.util;

import cr.model.Page;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by 小富 on 2018/1/25.
 * list分页查询
 */
@Component
public class ListPageUtil<T> {
    @Resource
    private Page<T> page;

    public Page<T> setListPage(List<T> data, int nowPage, int pageSize) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("查询list为空");
        }

        page.setData(data);
        page.setPageSize(pageSize);
        /*this.totalPage = data.size()/pageSize;
        if(data.size()%pageSize!=0){
            this.totalPage++;
        }*/
        page.setNowPage(nowPage);
        page.setTotalCount(data.size());

        page.setTotalPage((page.getTotalCount() + pageSize - 1) / pageSize);
        return page;
    }




}

