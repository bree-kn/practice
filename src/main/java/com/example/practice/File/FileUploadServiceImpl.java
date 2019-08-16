package com.example.practice.File;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.practice.trycatchpackage.ErrorEnum;
import com.example.practice.trycatchpackage.ResultData;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.naming.EjbRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Parameter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${taxpayurl}")
    private String taxpayurl;

    @Value("${storeToLocalPath}")
    private String storeToLocalPath;

    @Value("${url}")
    private String url;

    @Override
    public ResultData upload(HttpServletRequest request, String imageFileCount) {
        ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS, null);
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> multipartFileList = new ArrayList<>();
        Iterator<String> iter = multiRequest.getFileNames();
        while (iter.hasNext()) {
            MultipartFile multipartFile = multiRequest.getFile(iter.next());
            multipartFileList.add(multipartFile);
        }
        //将MultipartFile集合转为File集合
        List<File> fileList = convertToFileList(multipartFileList);
        //将获得的file集合和参数通过HttpClient传给接口
        try {
            String content = uploadFile(fileList, imageFileCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData storeToLocal(HttpServletRequest request, String imageFileCount) {
        ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS, null);
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter = multipartHttpServletRequest.getFileNames();
        List<MultipartFile> multipartFileList = new ArrayList<>();
        while (iter.hasNext()){
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(iter.next());
            multipartFileList.add(multipartFile);
        }

        for(MultipartFile multipartFile : multipartFileList){
            File file = new File(storeToLocalPath+multipartFile.getOriginalFilename());
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultData;
    }

    /**
     * .通过addPart方法只能添加ContentBody类型的数据，在org.apache.http.entity.mime.content包中已经提供了String、File以及InputStream对应的ContentBody类型的子类，
     * 如FileBody、InputStreamBody、StringBody，通过这些类我们可以将String、File以及InputStream类型的数据转换成ContentBody类型的数据。
     *
     * @param fileList
     * @param count
     * @return
     */
    private String uploadFile(List<File> fileList, String count) throws IOException {
        //传url,param,file
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String content = null;
        httpClient = HttpClients.createDefault();
        String url = taxpayurl + "tImage/uploadImgs";
        HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            FileBody bin = new FileBody(file);
            multipartEntityBuilder.addPart("imageFile" + i, bin);
        }
        StringBody countBody = new StringBody(count);
        multipartEntityBuilder.addPart("imageFileCount", countBody);
        HttpEntity reqEntity = multipartEntityBuilder.build();
        httpPost.setEntity(reqEntity);
        httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        if (resEntity != null) {
            content = resEntity.toString();
            return content;
        }
        return content;
    }

    private List<File> convertToFileList(List<MultipartFile> multipartFileList) {
        List<File> fileList = new ArrayList<>();
        int b = 0;
        for (MultipartFile multipartFile : multipartFileList) {
            File f = new File(multipartFile.getOriginalFilename());
            //try()是用来获取资源的，在try正常或异常结束时，（）里边的资源都会释放掉，此语句为自动释放资源。
            try (InputStream in = multipartFile.getInputStream(); OutputStream ous = new FileOutputStream(f)) {
                byte[] bytes = new byte[4096];
                //当!=-1时才去写文件
                while ((b = in.read(bytes)) != -1) {
                    ous.write(b);
                }
                fileList.add(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileList;
    }

    @Override
    public ResultData getNonParam(){
        ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS,null);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url+"httpRequest");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            if(responseEntity != null){
                String content = EntityUtils.toString(responseEntity);
                JSONObject contentObj = JSON.parseObject(content);
                resultData.setRtncode(contentObj.getString("code"));
                resultData.setMsg(contentObj.getString("msg"));
                resultData.setStatus(contentObj.getBoolean("status"));
                resultData.setTs(contentObj.getLong("ts"));
                resultData.setData(contentObj.get("data"));
                return resultData;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData getHaveParam(String name,int age){
        ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS,null);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        StringBuffer params = new StringBuffer();
        try {
            params.append("name="+URLEncoder.encode(name,"utf-8"));
            params.append("&");
            params.append("age="+age);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpGet httpGet = new HttpGet(url+"httpRequest?"+params);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            String content = EntityUtils.toString(responseEntity);
            JSONObject contentObj = JSONObject.parseObject(content);
            resultData.setRtncode(contentObj.getString("code"));
            resultData.setMsg(contentObj.getString("msg"));
            resultData.setStatus(contentObj.getBoolean("status"));
            resultData.setTs(contentObj.getLong("ts"));
            resultData.setData(contentObj.get("data"));
            return resultData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    //get请求并且有header
    //HttpGet httpGet = new HttpGet(url+"getHaveParamHeader?"+params);
    //        httpGet.addHeader("token",token);
    @Override
    public ResultData getHaveParamHeader(HttpServletRequest request, @RequestHeader(value = "token")String token, String name){
        ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS,null);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        StringBuffer params = new StringBuffer();
        params.append("name="+name);
        HttpGet httpGet = new HttpGet(url+"getHaveParamHeader?"+params);
        httpGet.addHeader("token",token);
        try {
            response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity);
            JSONObject contentObj = JSONObject.parseObject(content);
            resultData.setData(contentObj.getString("data"));
            return resultData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    // HttpPost httpPost = new HttpPost(url+"postNoParam");
    //        httpPost.addHeader("token",token);
    @Override
    public ResultData postNoParam(HttpServletRequest request,@RequestHeader(value = "token")String token){
        ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS,null);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost(url+"postNoParam");
        httpPost.addHeader("token",token);
        try {
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String content =EntityUtils.toString(httpEntity);
            JSONObject contentObj = JSONObject.parseObject(content);
            resultData.setData(contentObj.getString("data"));
            return resultData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData postHaveParam(HttpServletRequest request,@RequestHeader(value = "token")String token,String name){
        ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS,null);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        StringBuffer params = new StringBuffer();
        params.append("name="+name);
        HttpPost httpPost = new HttpPost(url+"postHaveParam?"+params);
        httpPost.addHeader("token",token);
        try {
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String content =EntityUtils.toString(httpEntity);
            JSONObject contentObj = JSONObject.parseObject(content);
            resultData.setData(contentObj.getString("data"));
            return resultData;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultData;
    }
}
