package org.sm.service;

import org.framework.annotation.Action;
import org.framework.view.JsonView;
import org.framework.web.ActionContext;
import org.framework.web.ViewResult;
import org.sm.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gell on 2016/12/29.
 */
public class ShowService {

    @Action("showStudents")
    public ViewResult showStudents(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        request.setAttribute("showStudents",new StudentsDao().getAllStudents());

        return new JsonView("students.html");
    }

    @Action("showStudentsClass")
    public ViewResult showStudentsClass(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String sclass = request.getParameter("sclass");

        request.setAttribute("showStudentsClass",new StudentsDao().getStudents_class(sclass));

        return new JsonView("students.html");
    }

    @Action("showOneStudent")
    public ViewResult showOneStudent(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String sNo = request.getParameter("sNo");

        request.setAttribute("showOneStudent",new StudentsDao().getOneStudent(sNo));

        return new JsonView("students.html");
    }

    @Action("showTeachers")
    public ViewResult showTeachers(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        request.setAttribute("showTeachers",new TeachersDao().getAllTeachers());

        return new JsonView("teachers.html");
    }

    @Action("showTeacher")
    public ViewResult showTeacher(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String tNo = request.getParameter("tNo");

        request.setAttribute("showTeacher",new TeachersDao().getTeacher(tNo));

        return new JsonView("teachers.html");
    }

    @Action("showDormitorys")
    public ViewResult showDormitorys(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        request.setAttribute("showDormitorys",new DormitorysDao().getAllDormitorys());

        return new JsonView("Dormitory.html");
    }

    @Action("showDormitory")
    public ViewResult showDormitory(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String dName = request.getParameter("dName");

        request.setAttribute("showDormitory",new DormitorysDao().getDormitory(dName));

        return new JsonView("Dormitory.html");
    }

    @Action("showDormitorySign")
    public ViewResult showDormitorySign(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");

        Date signDate = null;

        try {
            signDate = time.parse(request.getParameter("signDate"));

            request.setAttribute("showDormitorySign",new DormitorySignDao().getDormitorySign(signDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new JsonView("DormitorySign.html");
    }

    @Action("showAllDormitorySign")
    public ViewResult showAllDormitorySign(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        request.setAttribute("showAllDormitorySign",new DormitorySignDao().getAllDormitorySign());

        return new JsonView("DormitorySign.html");
    }

    @Action("showAllClasses")
    public ViewResult showAllClasses(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        request.setAttribute("showAllClasses",new ClassesDao().getAllClasses());

        return new JsonView("DormitorySign.html");
    }

    @Action("showAllClass")
    public ViewResult showClass(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        String cName = request.getParameter("cName");

        request.setAttribute("showAllClass",new ClassesDao().getOneClass(cName));

        return new JsonView("classes.html");
    }
}
