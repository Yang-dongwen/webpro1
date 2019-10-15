package com.javaweb.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (ServletFileUpload.isMultipartContent(request)){
            throw new RuntimeException("当前请求不支持文件上传");
        }
        // 为基于磁盘的文件项创建工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 配置存储库(确保使用安全的临时位置)
//        ServletContext servletContext = this.getServletConfig().getServletContext();
//        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//        factory.setRepository(repository);


        // 创建一个新的文件上传处理程序(核心代码)
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 解析请求
        try {
            List<FileItem> items = upload.parseRequest(request);

            //处理上传的项目
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();

                if (item.isFormField()) {
                    //处理一个常规表单字段
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println(name + " = " + value);
                } else {
                    System.out.println("执行文件上传");
                   // 处理文件上传
                    String fileName = item.getName();
                    InputStream is = item.getInputStream();
                    String path = this.getServletContext().getRealPath("/views");
                    File descFile = new File(path,fileName);
                    FileOutputStream os = new FileOutputStream(descFile);
                    int len = -1;
                    byte[] buf = new byte[1024];
                    while((len = is.read(buf)) != -1){
                        os.write(buf,0,len);
                    }
                    os.close();
                    is.close();

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }



    }

}