package org.sm.service;

import org.framework.view.RedirectView;
import org.framework.web.ActionContext;
import org.framework.web.ViewResult;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import org.sm.bean.Students;
import org.sm.utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Gell on 2016/12/28.
 */
public class LoginService {
    @Test
    public ViewResult login(){
        HttpServletRequest request = ActionContext.getContext().getRequest();
        Session session = new SessionUtils().getSession();
        String name = "mary";//request.getParameter("name")
        String pwd = "";//request.getParameter("pwd")

        Query q = session.createQuery("SELECT count(*) from Students " +
                "where sName = ? and sPwd = ?");
        List<Students>list = q.setParameter(0,name).setParameter(1,pwd).list();
        for(Students s : list){
            System.out.println(s.getsName());
        }


        return new RedirectView("index.jsp");
    }
}
