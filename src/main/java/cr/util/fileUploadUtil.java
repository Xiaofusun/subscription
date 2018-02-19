package cr.util;

import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by 小富 on 2018/1/30.
 */

public class fileUploadUtil {
    @Resource
    private CommonsMultipartResolver multipartResolver;
    private MultipartFile file=null;
    public  String fileUpload(HttpServletRequest request){
            multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
            if(multipartResolver.isMultipart(request)){
                MultipartHttpServletRequest servletRequest= (MultipartHttpServletRequest) request;
                Iterator iter=servletRequest.getFileNames();
            while (iter.hasNext()){
                file= servletRequest.getFile(iter.next().toString());
                if(file!=null){
                    try {
                        FileUtil.copyFile((File) file,new File("F:/subscription/src/main/webapp/images/"+file.getOriginalFilename()));
                    } catch (Exception e) {
                        throw new RuntimeException("文件转换异常");
                         }
                }

            }
            }
            return file.getOriginalFilename();
    }
    /*  MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="F:/subscription/src/main/webapp/images"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
*/
}
