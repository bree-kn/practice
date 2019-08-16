package com.example.practice.File;

import com.example.practice.trycatchpackage.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**upload
 * 从Postman发送数据参数和文件给此接口，然后通过这个接口将这些内容传给taxpay接口
 * postman->FileUploadController->taxpay
 * storeToLocal
 * 从postman获得的数据文件，保存到本地路径
 * multipartFile.transferTo(file);
 */
import javax.servlet.http.HttpServletRequest;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("upload")
    public ResultData upload(HttpServletRequest request, @RequestParam(value = "imageFileCount") String imageFileCount){
        ResultData resultData = fileUploadService.upload(request,imageFileCount);
        return resultData;
    }

    @RequestMapping("storeToLocal")
    public ResultData storeToLocal(HttpServletRequest request, @RequestParam(value = "imageFileCount") String imageFileCount){
        ResultData resultData = fileUploadService.storeToLocal(request,imageFileCount);
        return resultData;
    }
}
