package cr.servlet;

import cr.model.News;
import cr.model.Page;
import cr.service.NewService;
import cr.util.ListPageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 小富 on 2018/1/25.
 */
@Controller
@RequestMapping("/page.do")
public class NewsPageController {
    @Resource
    private NewService newService;
    @Resource
    private ListPageUtil listPageUtil;
    @Resource
    private Page<News> page;

    @RequestMapping(params = "method=listPage")
    public String ListPage( HttpSession session){
        List<News> list = newService.queryByType("国内新闻");
        page=listPageUtil.setListPage(list,1,10);
        List<News> lists=page.getPagedList();
        session.setAttribute("newsList",lists);
        return "/queryByType";
    }
}
