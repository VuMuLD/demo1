//package dao;
//
//import model.TaiKhoan;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class TaiKhoanDatabase {
//    Connection con;
//
//    public TaiKhoanDatabase(Connection con) {
//        this.con = con;
//    }
//
//    public boolean saveTaiKhoan(TaiKhoan taiKhoan){
//        boolean set = false;
//        try {
//            //Insert register data to database
//            String query = "insert into tai_khoan(ten_tai_khoan,ten_dang_nhap,mat_khau) values(?,?,?)";
//
//            PreparedStatement pt = this.con.prepareStatement(query);
//
//            pt.setString(1, taiKhoan.getTen_tai_khoan());
//            pt.setString(2, taiKhoan.getTen_dang_nhap());
//            pt.setString(3, taiKhoan.getMat_khau());
//
//            pt.executeUpdate();
//            set = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return set;
//    }
//
//
//    //log user
//    public TaiKhoan logTaiKhoan(String Ten_dang_nhap, String Mat_khau) {
//        TaiKhoan taiKhoan = null;
//
//        try {
//            String query = "select * from user where email=? and password=?";
//            PreparedStatement ps = this.con.prepareStatement(query);
//            ps.setString(1,Ten_dang_nhap);
//            ps.setString(2,Mat_khau);
//
//            ResultSet rs  = ps.executeQuery();
//
//            if(rs.next()){
//                taiKhoan = new TaiKhoan();
//                taiKhoan.setMa_tai_khoan(rs.getInt("Ma_tai_khoan"));
//                taiKhoan.setTen_tai_khoan(rs.getString("Ten_tai_khoan"));
//                taiKhoan.setTen_dang_nhap(rs.getString("Ten_dang_nhap"));
//                taiKhoan.setMat_khau(rs.getString("Mat_khau"));
//                taiKhoan.setQuyen_truy_cap(rs.getBoolean("Quyen_truy_cap"));
//
//                taiKhoan.setTinh_trang(rs.getBoolean("Tinh_trang"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return taiKhoan;
//    }
//}
//
