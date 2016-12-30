package org.sm.dao;

import org.sm.bean.Classes;
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
public class ClassesDao {
    private static Connection conn = null;
    private static ResultSet rs =null;
    private static PreparedStatement ps = null;

    public static boolean addClass(Classes classes){
        boolean bl = false;
        String sql = "insert into classes VALUES (?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(2, classes.getcNum());
            ps.setString(1, classes.getcName());
            ps.setString(3, classes.getHeadmaster());

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    public static boolean updateClass(Classes classes, String cName){
        boolean bl = false;
        String sql = "update classes set  cName = ?, cNum = ?, Headmaster = ? where cName = ?";


        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setInt(2, classes.getcNum());
            ps.setString(1, classes.getcName());
            ps.setString(3, classes.getHeadmaster());
            ps.setString(4, cName);

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    public static List<Classes> getAllClasses(){
        List<Classes> list = new ArrayList<>();

        String sql = "select * from classes";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if(rs.next()){
                Classes classes = new Classes();

                classes.setcName(rs.getString("cName"));
                classes.setHeadmaster(rs.getString("Headmaster"));
                classes.setcNum(rs.getInt("cNum"));
                classes.setcId(rs.getInt("cId"));

                list.add(classes);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return list;
    }
    public static Classes getOneClass(String cName){

        Classes classes = new Classes();
        String sql = "select * from classes where cName = ?";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, cName);

            rs = ps.executeQuery();

            if(rs.first()){

                classes.setcName(rs.getString("cName"));
                classes.setHeadmaster(rs.getString("Headmaster"));
                classes.setcNum(rs.getInt("cNum"));
                classes.setcId(rs.getInt("cId"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return classes;
    }
}
