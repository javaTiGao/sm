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

    public static int login(String name, String pwd){
        int i=0;
        boolean bl = false;
        String sql = "select count(*) as rowCount from teachers  where tName = ? and tPasswd = ?";


        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2, pwd);

            rs = ps.executeQuery();

            if (rs.first()){
                i = 1;
            }



            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        if(i == 1){
            return i;
        }else {
            sql = "select count(*) as rowCount from students  where sName = ? and sPwd = ?";

            try {
                conn = DBUtil.getConnection();
                ps = conn.prepareStatement(sql);

                ps.setString(2, pwd);
                ps.setString(1,name);

                rs = ps.executeQuery();

                if (rs.first()){
                    i = 2;
                }

                System.out.println(i);

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                DBUtil.closeConn(rs, ps, conn);
            }
        }

        return i;
    }

        // public static void main(String[] args) {
            //login("a", "123456");
        //}
}
