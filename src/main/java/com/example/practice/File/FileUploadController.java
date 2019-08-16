package com.example.practice.File;

import com.example.practice.trycatchpackage.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**1.upload
 * 从Postman发送数据参数和文件给此接口，然后通过这个接口将这些内容传给taxpay接口
 * postman->FileUploadController->taxpay
 * 2.storeToLocal
 * 从postman获得的数据文件，保存到本地路径
 * multipartFile.transferTo(file);
 * 3.httpclient发送数据，参数，header都可以让接受方的方法上面接受，name对应那边的id,header对应那边的header，可以直接用，不用从
 * request里边取。
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

    //get 无参
    @RequestMapping("getNonParam")
    public ResultData getNonParam(){
        ResultData resultData = fileUploadService.getNonParam();
        return resultData;
    }
    //get 有参
    //@@RequestParam(value = "name") String name1可以不写requestparam,但传进来的参数的名字必须和方法上名字一致
    //@RequestBody注解可以接收json格式的数据，并将其转换成对应的数据类型,用于Post请求，不能用于get请求，
    //可以接受字符串，对象等
    //*******基本类型的参数就用string name等传进来，如果像文件等就放在request中获取了。*******
    @RequestMapping("getHaveParam")
    public ResultData getHaveParam(@RequestParam(value = "name")String name,@RequestParam(value = "age") int age){
        ResultData resultData = fileUploadService.getHaveParam(name,age);
        return resultData;
    }

    //get有参数，有header
    @RequestMapping("getHaveParamHeader")
    public ResultData getHaveParamHeader(HttpServletRequest request,@RequestHeader(value = "token")String token,String name){
        ResultData resultData = fileUploadService.getHaveParamHeader(request,token,name);
        return resultData;
    }

    //post无参数
    @RequestMapping("postNoParam")
    public ResultData postNoParam(HttpServletRequest request,@RequestHeader(value = "token")String token){
        ResultData resultData = fileUploadService.postNoParam(request,token);
        return resultData;
    }

    //post有参数,有header
    @RequestMapping("postHaveParam")
    public ResultData postHaveParam(HttpServletRequest request,@RequestHeader(value = "token")String token,String name){
        ResultData resultData = fileUploadService.postHaveParam(request,token,name);
        return resultData;
    }

}
