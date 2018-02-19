package cr.servlet;

import com.mysql.jdbc.Blob;
import cr.model.Body;
import cr.service.BodyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by 小富 on 2018/1/28.
 */
@Controller
@RequestMapping("body.do")
public class BodyController {
    @Resource
    private BodyService bodyService;
    @RequestMapping(params = "method=queryByIdBody")
    public  String queryByIdBody(int bid, HttpServletRequest request) throws UnsupportedEncodingException {
        Body body=bodyService.getById(bid);
        Blob blob=null;
        //控制台输出
        /*ByteArrayInputStream stream=new ByteArrayInputStream(body.getBody().getBytes());
        stream.
        */
        byte[] bytes = null;
        bytes = body.getBody().getBytes("utf-8");
        System.out.println("===" + bytes.toString());
                // String bodys=new String(body.getBody().getBytes("gbk"),"utf-8");
        //System.out.println(bodys);
        //request.setAttribute("body",body);
        return "/body";
    }
}
