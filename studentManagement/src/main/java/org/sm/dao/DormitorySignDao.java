package org.sm.dao;

import org.sm.bean.DormitorySign;
import org.sm.utils.DBUtil;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gell on 2016/12/29.
 */
public class DormitorySignDao {
    private static Connection conn = null;
    private static ResultSet rs =null;
    private static PreparedStatement ps = null;

    public static boolean addSign(DormitorySign dormitorySign){
        boolean bl = false;
        String sql = "insert into dormitorysign VALUES (?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(2, dormitorySign.getsSign());
            ps.setString(1, dormitorySign.getdName());
            ps.setDate(3, (java.sql.Date) dormitorySign.getSignDate());

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    /*public static boolean updateDormitorySign(DormitorySign dormitorySign, String dName, String sSign, Date signDate){
        boolean bl = false;
        String sql = "update dormitorysign set  dName = ?, sSign = ?, signDate = ? where dName = ? and sSign =? and signDate = ?";


        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, dormitorySign.getdName());
            ps.setString(2, dormitorySign.getsSign());
            ps.setDate(3, (java.sql.Date) dormitorySign.getSignDate());
            ps.setString(4, dName);
            ps.setString(5, sSign);
            ps.setDate(6, (java.sql.Date) signDate);

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }*/

    public static List<DormitorySign> getAllDormitorySign(){
        List<DormitorySign> list = new ArrayList<>();

        String sql = "select * from dormitorysign";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if(rs.next()){
                DormitorySign dormitorySign = new DormitorySign();

                dormitorySign.setdName(rs.getString("dName"));
                dormitorySign.setSignDate(rs.getDate("signDate"));
                dormitorySign.setsSign(rs.getString("sSign"));


                list.add(dormitorySign);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return list;
    }
    public static List<DormitorySign> getDormitorySign(Date signDate){
        List<DormitorySign> list = new ArrayList<>();

        String sql = "select * from dormitorysign where signDate = ?";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);


            ps.setDate(1, (java.sql.Date) signDate);

            rs = ps.executeQuery();

            if(rs.first()){
                DormitorySign dormitorySign = new DormitorySign();

                dormitorySign.setdName(rs.getString("dName"));
                dormitorySign.setsSign(rs.getString("sSign"));
                dormitorySign.setSignDate(rs.getDate("signDate"));

                list.add(dormitorySign);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return list;
    }
}
