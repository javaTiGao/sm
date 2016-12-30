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

/**
 * Created by Gell on 2016/12/28.
 */
public class LoginService {
    @Action("/login")
    public static ViewResult login(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        int i = new LoginDao().login(name, pwd);

        if (i == 1){
            return new ForwardView("teachers.html");
        }else if(i == 2){
            return new ForwardView("students.html");
        }


        return new ForwardView("login.html");
    }

}
