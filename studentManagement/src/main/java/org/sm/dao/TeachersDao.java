package org.sm.dao;

import org.sm.bean.Students;
import org.sm.bean.Teachers;
import org.sm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gell on 2016/12/29.
 */
public class TeachersDao {
    private static Connection conn = null;
    private static ResultSet rs =null;
    private static PreparedStatement ps = null;

    public static boolean addTeacher(Teachers teachers){
        boolean bl = false;
        String sql = "insert into teachers VALUES (?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, teachers.gettName());
            ps.setString(2, teachers.gettClasses());
            ps.setString(3, teachers.gettPasswd());

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    public static boolean updateTeacher(Teachers teachers, String tNo){
        boolean bl = false;
        String sql = "update teachers set tNo = ?, tName = ?, tClass = ?, tPwd = ? where tNo = ?";


        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, teachers.gettNo());
            ps.setString(2, teachers.gettName());
            ps.setString(3, teachers.gettClasses());
            ps.setString(4, teachers.gettPasswd());
            ps.setString(5, tNo);

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    public static List<Teachers> getAllTeachers(){
        List<Teachers> list = new ArrayList<>();

        String sql = "select * from teachers";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if(rs.next()){
                Teachers teachers = new Teachers();

                teachers.settNo(rs.getString("tNo"));
                teachers.settName(rs.getString("tName"));
                teachers.settClasses(rs.getString("tClasses"));
                teachers.settPasswd(rs.getString("tPasswd"));


                list.add(teachers);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return list;
    }
    public static Teachers getTeacher(String tNo){

        Teachers teachers = new Teachers();
        String sql = "select * from teachers where sNo = ?";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, tNo);

            rs = ps.executeQuery();

            if(rs.first()){
                teachers.settNo(rs.getString("tNo"));
                teachers.settName(rs.getString("tName"));
                teachers.settClasses(rs.getString("tClasses"));
                teachers.settPasswd(rs.getString("tPasswd"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return teachers;
    }
}
