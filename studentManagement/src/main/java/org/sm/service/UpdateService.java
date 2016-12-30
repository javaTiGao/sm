package org.sm.service;

import org.framework.annotation.Action;
import org.framework.view.JsonView;
import org.framework.web.ActionContext;
import org.framework.web.ViewResult;
import org.sm.bean.Classes;
import org.sm.bean.Dormitorys;
import org.sm.bean.Students;
import org.sm.bean.Teachers;
import org.sm.dao.ClassesDao;
import org.sm.dao.DormitorysDao;
import org.sm.dao.StudentsDao;
import org.sm.dao.TeachersDao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gell on 2016/12/29.
 */
public class UpdateService {

    @Action("updateClass")
    public ViewResult updateClass(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Classes classes = new Classes();
        String cName = request.getParameter("cName");

        classes.setHeadmaster(request.getParameter("Headmaster"));
        classes.setcName(request.getParameter("cName"));
        classes.setcNum(Integer.parseInt(request.getParameter("cNum")));

        request.setAttribute("updateClass", new ClassesDao().updateClass(classes, cName));

        return new JsonView("updateClass.html");
    }

    @Action("updateDormitory")
    public ViewResult updateDormitory(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Dormitorys dormitorys = new Dormitorys();
        String dName = request.getParameter("dName");

        dormitorys.setdClass(request.getParameter("dClass"));
        dormitorys.setdLord(request.getParameter("dLord"));
        dormitorys.setMaxNum(Integer.parseInt(request.getParameter("maxNum")));
        dormitorys.setNum(Integer.parseInt(request.getParameter("num")));
        dormitorys.setdName(request.getParameter("dName"));

        request.setAttribute("updateDormitory", new DormitorysDao().updateDormitory(dormitorys, dName));

        return new JsonView("updateDormitory.html");
    }

    @Action("updateStudent")
    public ViewResult updateStudent(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Students students = new Students();
        String sNo = request.getParameter("sNo");

        students.setHeadmaster(request.getParameter("Headmaster"));
        students.setsPwd(request.getParameter("sPwd"));
        students.setsNo(request.getParameter("sNo"));
        students.setsName(request.getParameter("sName"));
        students.setsClass(request.getParameter("sClass"));
        students.setsSex(request.getParameter("sSex"));

        request.setAttribute("updateStudent", new StudentsDao().updateStudent(students, sNo));

        return new JsonView("updateStudent.html");
    }

    @Action("updateTeacher")
    public ViewResult updateTeacher(){
        HttpServletRequest request = ActionContext.getContext().getRequest();

        Teachers teachers = new Teachers();
        String tNo = request.getParameter("tNo");

        teachers.settName(request.getParameter("tName"));
        teachers.settPasswd(request.getParameter("tPasswd"));
        teachers.settClasses(request.getParameter("tClasses"));
        teachers.settNo(request.getParameter("tNo"));

        request.setAttribute("updateTeacher", new TeachersDao().updateTeacher(teachers, tNo));

        return new JsonView("updateTeacher.html");
    }
}
