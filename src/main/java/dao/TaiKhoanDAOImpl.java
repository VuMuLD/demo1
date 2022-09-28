package dao;

import Context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaiKhoanDAOImpl implements TaiKhoanDAO{

    @Override
    public boolean kiemTraTaiKhoan(String ten_dang_nhap) {
        Connection cons = DBContext.getInstance().getConnection();
        String sql = "select ten_dang_nhap from tai_khoan where ten_dang_nhap = '"+ten_dang_nhap+"'";
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return true;
            }
            cons.close();
        } catch (SQLException e) {

            Throwable ex = null;
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
