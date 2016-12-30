package org.sm.dao;

import org.sm.bean.Students;
import org.sm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * Created by Gell on 2016/12/29.
 */
public class LoginDao {
    private static Connection conn = null;
    private static ResultSet rs =null;
    private static PreparedStatement ps = null;

    public static String teacherLogin(String name, String pwd){
        String sf = null;
        boolean bl = false;
        String sql = "select count(*) as rowCount from teachers  where tName = ? and tPasswd = ?";

        conn = DBUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2, pwd);

            rs = ps.executeQuery();

            if (rs.first()){
                sf = "老师";
            }

            System.out.println(sf);


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }



        return sf;
    }
	
	public static String studentLogin(String name, String pwd){
        String sf = null;
        boolean bl = false;
        String sql = "select count(*) as rowCount from students  where sName = ? and sPwd = ?";

        conn = DBUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2, pwd);

            rs = ps.executeQuery();

            if (rs.first()){
                sf = "学生";
            }

            System.out.println(sf);


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }
		
        return sf;
    }

        // public static void main(String[] args) {
            //login("a", "123456");
        //}
}
