package org.lanqiao.servlet;

import org.lanqiao.service.IStudentService;
import org.lanqiao.service.impl.StudentServceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

public class QueryStudentByIdServelet extends javax.servlet.http.HttpServlet {
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    IStudentService studentService ;



    //************初期化　获取SpringIOC的bean对象************* spring mvc 已经集合servlet コンテナー　と spring ioc コンテナーの連携
    public void init() throws  SecurityException{
      //  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Service.xml");

        //**********web プロジェクト获取spring上下文对象 就是获取bean***************
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        studentService = (IStudentService)context.getBean("studentService");
    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

       String name = studentService.queryStudentID();
        request.setAttribute("name",name);
        request.getRequestDispatcher("result.jsp").forward(request,response);


    }
}
