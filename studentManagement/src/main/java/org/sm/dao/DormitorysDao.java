package org.sm.dao;

import org.sm.bean.Dormitorys;
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
public class DormitorysDao {
    private static Connection conn = null;
    private static ResultSet rs =null;
    private static PreparedStatement ps = null;

    public static List<Dormitorys> getAllDormitorys(){
        List<Dormitorys> list = new ArrayList<>();

        String sql = "select * from dormitorys";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if(rs.next()){
                Dormitorys dormitorys = new Dormitorys();

                dormitorys.setdClass(rs.getString("dClass"));
                dormitorys.setdId(rs.getInt("dId"));
                dormitorys.setdLord(rs.getString("dLord"));
                dormitorys.setdName(rs.getString("dName"));
                dormitorys.setMaxNum(rs.getInt("maxNum"));
                dormitorys.setNum(rs.getInt("num"));

                list.add(dormitorys);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return list;
    }

    public static Dormitorys getDormitory(String dName){

        Dormitorys dormitorys = new Dormitorys();
        String sql = "select * from dormitorys where dName = ?";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, dName);

            rs = ps.executeQuery();

            if(rs.first()){
                dormitorys.setdClass(rs.getString("dClass"));
                dormitorys.setdId(rs.getInt("dId"));
                dormitorys.setdLord(rs.getString("dLord"));
                dormitorys.setdName(rs.getString("dName"));
                dormitorys.setMaxNum(rs.getInt("maxNum"));
                dormitorys.setNum(rs.getInt("num"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return dormitorys;
    }

    public static boolean addDormitory(Dormitorys dormitorys){
        boolean bl = false;
        String sql = "insert into dormitorys VALUES (?,?,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, dormitorys.getdName());
            ps.setString(2, dormitorys.getdClass());
            ps.setInt(3, dormitorys.getMaxNum());
            ps.setInt(4, dormitorys.getNum());
            ps.setString(5, dormitorys.getdLord());

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }

    public static boolean updateDormitory(Dormitorys dormitorys, String dName){
        boolean bl = false;
        String sql = "update dormitorys set dName = ?, dClass = ?, maxNm = ?, num = ?, dLord = ? where dName = ?";


        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, dormitorys.getdName());
            ps.setString(2, dormitorys.getdClass());
            ps.setInt(3, dormitorys.getMaxNum());
            ps.setString(5, dormitorys.getdLord());
            ps.setInt(4, dormitorys.getNum());
            ps.setString(6, dName);

            bl = ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConn(rs, ps, conn);
        }

        return bl;
    }
}
