package dao;

import Context.DBContext;
import model.TaiKhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    @Override
    public boolean kiemTraTaiKhoan(String ten_dang_nhap) {
        Connection cons = DBContext.getInstance().getConnection();
        String sql = "select ten_dang_nhap from tai_khoan where ten_dang_nhap = '" + ten_dang_nhap + "'";
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public void themTaiKhoan(TaiKhoan tk) {
        Connection cons = DBContext.getInstance().getConnection();
        String sql = "insert into tai_khoan value (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, tk.getMa_tai_khoan());
            ps.setString(2, tk.getTen_tai_khoan());
            ps.setString(3, tk.getTen_dang_nhap());
            ps.setString(4, tk.getMat_khau());
            ps.setInt(5, tk.getQuyen_truy_cap());
            ps.setInt(6, tk.getTinh_trang());
            ps.executeUpdate();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
