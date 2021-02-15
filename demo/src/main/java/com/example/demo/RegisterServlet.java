package com.example.demo;

import com.example.demo.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");


        String Email = req.getParameter("email");
        String Password = req.getParameter("password");
        String ConfirmPassword = req.getParameter("c_password");
        String Gender = req.getParameter("gender");
        String Country = req.getParameter("country");
        String hobby="";
        if(req.getParameter("cricket")!=null) hobby+="cricket,";
        if(req.getParameter("football")!=null) hobby+="football";
        String Address = req.getParameter("address");

        UserBean userBean = new UserBean();
        userBean.setEmail(Email);
        userBean.setPassword(Password);
        userBean.setConfirmPassword(ConfirmPassword);
        userBean.setGender(Gender);
        userBean.setCountry(Country);
        userBean.setHobby(hobby);
        userBean.setAddress(Address);

        req.setAttribute("USERLIST",userBean);
        req.getRequestDispatcher("userlist.jsp").forward(req,resp);


    }
}
