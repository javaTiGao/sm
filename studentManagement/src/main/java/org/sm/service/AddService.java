package org.sm.service;

import org.framework.annotation.Action;
import org.framework.view.JsonView;
import org.framework.web.ActionContext;
import org.framework.web.ViewResult;
import org.sm.bean.*;
import org.sm.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gell on 2016/12/29.
 */
public class AddService {

    @Action("addClass")
    public ViewResult addClass(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Classes classes = new Classes();

        classes.setcNum(Integer.parseInt(request.getParameter("cNum")));
        classes.setcName(request.getParameter("cName"));
        classes.setHeadmaster(request.getParameter("Headmaster"));

        request.setAttribute("addClass",new ClassesDao().addClass(classes));

        return new JsonView("add.html");
    }

    @Action("addSign")
    public ViewResult addSign(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        DormitorySign dormitorySign = new DormitorySign();

        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");

        dormitorySign.setdName(request.getParameter("dName"));
        dormitorySign.setsSign(request.getParameter("sSign"));
        try {
            dormitorySign.setSignDate(time.parse(request.getParameter("signDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        request.setAttribute("addSign",new DormitorySignDao().addSign(dormitorySign));

        return new JsonView("add.html");
    }

    @Action("addDormitory")
    public ViewResult addDormitory(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Dormitorys dormitorys = new Dormitorys();

        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");

        dormitorys.setdName(request.getParameter("dName"));
        dormitorys.setNum(Integer.parseInt(request.getParameter("num")));
        dormitorys.setMaxNum(Integer.parseInt(request.getParameter("maxNum")));
        dormitorys.setdLord(request.getParameter("dLord"));
        dormitorys.setdClass(request.getParameter("dClass"));

        request.setAttribute("addDormitory",new DormitorysDao().addDormitory(dormitorys));

        return new JsonView("add.html");
    }

    @Action("addStudent")
    public ViewResult addStudent(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Students students = new Students();

        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");

        students.setsPwd(request.getParameter("sPwd"));
        students.setsSex(request.getParameter("sSex"));
        students.setsClass(request.getParameter("sClass"));
        students.setHeadmaster(request.getParameter("Headmaster"));
        students.setsName(request.getParameter("sName"));
        students.setsNo(request.getParameter("sNo"));

        request.setAttribute("addStudent",new StudentsDao().addStudent(students));

        return new JsonView("add.html");
    }

    @Action("addTeacher")
    public ViewResult addTeacher(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Teachers teachers = new Teachers();

        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");

        teachers.settName(request.getParameter("tName"));
        teachers.settNo(request.getParameter("tNo"));
        teachers.settPasswd(request.getParameter("tPasswd"));
        teachers.settClasses(request.getParameter("tClasses"));


        request.setAttribute("addTeacher",new TeachersDao().addTeacher(teachers));

        return new JsonView("add.html");
    }

}
