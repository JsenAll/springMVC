package com.jsen.servlet;
/**
 * @author Jsen
 * @description
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
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
import java.util.List;
import java.util.UUID;

public class FileServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        //判断上传文件是普通表单还是带文件的表单
        if (!ServletFileUpload.isMultipartContent(req)) return;
        //创建上传文件的保存路径,建议创建在WEB-INF路径下,安全.用户无法直接访问该路径下的内容
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) uploadFile.mkdir();//判断是否存在 不存在创建
        //缓存 临时文件
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if (!tmpFile.exists()) tmpFile.mkdir();//判断是否存在 不存在创建

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024);//缓冲区的大小
        factory.setRepository(tmpFile);//临时文件的保存目录

        ServletFileUpload upload = new ServletFileUpload(factory);

        //监听文件的上传进度
        upload.setProgressListener(new ProgressListener() {
            public void update(long l, long l1, int i) {
                System.out.println("总大小: " + l1 + " 已经上传: " + l);
            }
        });

        //处理乱码问题
        upload.setHeaderEncoding("UTF-8");

        //设置单个文件的最大值
        upload.setFileSizeMax(1024 * 1024 * 1024 * 10);

        //设置总共上传文件的大小
        upload.setSizeMax(1024 * 1024 * 1024 * 10);

        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(req);
            fileItems.forEach(fileItem -> {
                if (fileItem.isFormField()) {
                    String uploadFileName = fileItem.getName();

                } else {
                    //是上传文件的控件
                    //+++++++++++++++处理文件+++++++++++++++++++++++++//
                    String uploadFileName = fileItem.getName();
                    if (uploadFileName == null || uploadFileName.trim().equals("")) return;
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                    String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    System.out.println("文件名: " + fileName + " 文件类型: " + fileExtName);
                    //+++++++++++++++文件存放+++++++++++++++++++++++++//
                    String uuidPath = UUID.randomUUID().toString();
                    String realPath = uploadPath + "/" + uuidPath;
                    File realPathFile = new File(realPath);
                    if (!realPathFile.exists()) realPathFile.mkdir();
                    //+++++++++++++++文件传输+++++++++++++++++++++++++//
                    InputStream inputStream = null;
                    FileOutputStream fos = null;
                    try {
                        inputStream = fileItem.getInputStream();
                        fos = new FileOutputStream(realPath + "/" + fileName);
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = inputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fos.close();
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });

        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }
}
