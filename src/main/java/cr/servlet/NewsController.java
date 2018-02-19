package cr.servlet;

import cr.model.News;
import cr.model.mapper.NewsMapper;
import cr.service.NewService;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 小富 on 2018/1/23.
 */
@Controller
@RequestMapping("/newsController.do")
public class NewsController {

    String Filepath="F:\\subscription\\src\\main\\webapp\\images\\";

    @Resource
    private NewService newService;
  /*  @Resource
    private CommonsMultipartResolver multipartResolver;
    private MultipartFile file = null;*/

    @RequestMapping(params = "method=queryByType")
    public String queryByType(@RequestParam("newstype") String type, HttpServletRequest request) {
        List<News> newsList = newService.queryByType(type);
        request.setAttribute("newslist", newsList);
        return "queryByType";
    }

    @RequestMapping( method= RequestMethod.POST)
    public String addNews(@RequestParam("file") CommonsMultipartFile file) throws IOException {
       System.out.println("fileName："+file.getOriginalFilename());

        File newFile=new File(Filepath+file.getOriginalFilename());
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
          //控制台输出
          System.out.println("进入测试");
            return "test";
        }

    public NewService getNewService() {
        return newService;
    }

    public void setNewService(NewService newService) {
        this.newService = newService;
    }
}
