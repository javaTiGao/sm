package org.sm.dao;

import org.sm.bean.Students;
import org.sm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gell on 2016/12/29.
 */
public class StudentsDao {
    private static Connection conn = null;
    private static ResultSet rs =null;
    private static PreparedStatement ps = null;

    public static boolean addStudent(Students students){
        boolean bl = false;
        String sql = "insert into students VALUES (?,?,?,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, students.getsNo());
            ps.setString(2, students.getsName());
            ps.setString(3, students.getsSex());
            ps.setString(4, students.getsClass());
            ps.setString(5, students.getHeadmaster());
            ps.setString(6, students.getsPwd());

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    public static boolean updateStudent(Students students, String sNo){
        boolean bl = false;
        String sql = "update students set sNo = ?, sName = ?, sSex = ?, sClass = ?, Headmaster = ?, sPwd = ? where sNo = ?";


        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, students.getsNo());
            ps.setString(2, students.getsName());
            ps.setString(3, students.getsSex());
            ps.setString(4, students.getsClass());
            ps.setString(6, students.getsPwd());
            ps.setString(5, students.getHeadmaster());
            ps.setString(7, sNo);

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    public static List<Students> getAllStudents(){
        List<Students> list = new ArrayList<>();

        String sql = "select * from students";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if(rs.next()){
                Students students = new Students();

                students.setsName(rs.getString("sName"));
                students.setHeadmaster(rs.getString("Headmaster"));
                students.setsClass(rs.getString("sClass"));
                students.setsId(rs.getInt("sId"));
                students.setsNo(rs.getString("sNo"));
                students.setsSex(rs.getString("sSex"));
                students.setsPwd(rs.getString("sPwd"));
                students.setSsf(rs.getString("ssf"));

                list.add(students);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return list;
    }
    public static Students getOneStudent(String sNo){

        Students students = new Students();
        String sql = "select * from students where sNo = ?";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, sNo);

            rs = ps.executeQuery();

            if(rs.first()){

                students.setsName(rs.getString("sName"));
                students.setHeadmaster(rs.getString("Headmaster"));
                students.setsClass(rs.getString("sClass"));
                students.setsId(rs.getInt("sId"));
                students.setsNo(rs.getString("sNo"));
                students.setsSex(rs.getString("sSex"));
                students.setsPwd(rs.getString("sPwd"));
                students.setSsf(rs.getString("ssf"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return students;
    }

    public static List<Students> getStudents_class(String sclass){
        List<Students> list = new ArrayList<>();

        String sql = "select * from students where sClass = ?";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, sclass);

            rs = ps.executeQuery();

            if(rs.first()){
                Students students = new Students();
                students.setsName(rs.getString("sName"));
                students.setHeadmaster(rs.getString("Headmaster"));
                students.setsClass(rs.getString("sClass"));
                students.setsId(rs.getInt("sId"));
                students.setsNo(rs.getString("sNo"));
                students.setsSex(rs.getString("sSex"));

                students.setSsf(rs.getString("ssf"));
                students.setsPwd(rs.getString("sPwd"));

                list.add(students);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return list;
    }

}
