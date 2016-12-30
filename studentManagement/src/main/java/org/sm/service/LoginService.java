package org.sm.service;

import org.framework.annotation.Action;
import org.framework.view.ForwardView;
import org.framework.view.JsonView;
import org.framework.view.RedirectView;
import org.framework.web.ActionContext;
import org.framework.web.ViewResult;
import org.sm.bean.Students;
import org.sm.dao.LoginDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginService {
    @Action("/teacherLogin")
    public static ViewResult login(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        System.out.println(name);
        System.out.println(pwd);

        String sf = new LoginDao().teacherLogin(name, pwd);

        if (sf != null && sf.equals("老师")){
            return new ForwardView("/show/teachers.jsp");
        }


        return new ForwardView("login.html");
    }

    @Action("/studentLogin")
    public static ViewResult studentLogin(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        System.out.println(name);
        System.out.println(pwd);

        String sf = new LoginDao().studentLogin(name, pwd);

        if (sf != null && sf.equals("学生")){
            return new ForwardView("/show/students.jsp");
        }


        return new ForwardView("login.html");
    }

}
