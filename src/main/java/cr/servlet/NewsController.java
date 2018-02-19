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

    String Filepath = "F:\\subscription\\src\\main\\webapp\\images\\";

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

    @RequestMapping(method = RequestMethod.POST)
    public String addNews(@RequestParam("file") CommonsMultipartFile[] file) throws IOException {
        Boolean b;
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        for (int i = 0; i < file.length; i++) {
            file[i].transferTo(new File(Filepath + file[i].getOriginalFilename()));

        }
        if (!file.equals(null)) {
            //删除上传原文件
            file.clone();
        }
        //控制台输出
        System.out.println(file);
        return "test";
    }

        /*
        * 第二种上传
        * */
       /* @RequestMapping( method= RequestMethod.POST)
        public String  addNews(HttpServletRequest request) throws IllegalStateException, IOException
        {
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                    request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"
            if(multipartResolver.isMultipart(request)) {
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //获取multiRequest 中所有的文件名
                Iterator iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //一次遍历所有文件
                    MultipartFile file = multiRequest.getFile(iter.next().toString());
                    if (file != null) {
                        String path = Filepath + file.getOriginalFilename();
                        //上传
                        file.transferTo(new File(path));
                    }
                }
            }
            return "test";
        }*/

    public NewService getNewService() {
        return newService;
    }

    public void setNewService(NewService newService) {
        this.newService = newService;
    }
}
