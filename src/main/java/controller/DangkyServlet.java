package controller;

import dao.TaiKhoanDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DangkyServlet", value = "/DangkyServlet")
public class DangkyServlet extends HttpServlet {

    private TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten_tai_khoan = request.getParameter("ten_tai_khoan");
        String ten_dang_nhap = request.getParameter("ten_dang_nhap");
        String mat_khau = request.getParameter("mat_khau");

        String ten_tai_khoan_err = "", ten_dang_nhap_err = "", mat_khau_err = "";
        //
        if (ten_tai_khoan.equals("")) {
            ten_tai_khoan_err = "Vui lòng nhập họ và tên của bạn !";
        }
        if (ten_tai_khoan_err.length() > 0) {
            request.setAttribute("ten_tai_khoan_err", ten_tai_khoan_err);
        }
        //
        if (ten_dang_nhap.equals("")) {
            ten_dang_nhap_err = "Vui lòng nhập email của bạn !";
        } else if (taiKhoanDAO.kiemTraTaiKhoan(ten_dang_nhap) == true) {
            ten_dang_nhap_err = "Địa chỉ email đã đươc đăng ký !";

        }
        if (ten_dang_nhap.length() > 0) {
            request.setAttribute("ten_dang_nhap_err", ten_dang_nhap_err);
        }
        //
        if (mat_khau.equals("")) {
            mat_khau_err += "Vui lòng nhập mật khẩu của bạn !";
        }
        if (mat_khau_err.length() > 0) {
            request.setAttribute("mat_khau_err", mat_khau_err);
        }
        String url = "/account.jsp";

        try {
            if (mat_khau_err.length() == 0 && ten_dang_nhap_err.length() == 0 && ten_tai_khoan_err.length() == 0) {
                url = "/account.jsp";
            } else {
                url = "/account.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (Exception e) {

        }

    }
}