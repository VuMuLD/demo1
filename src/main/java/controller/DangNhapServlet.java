package controller;

import Context.DBContext;
import dao.TaiKhoanDAOImpl;
import dao.TaiKhoanDatabase;
import model.TaiKhoan;
import tools.MaHoa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "DangNhapServlet", value = "/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getParameter("command").equals("logout")) {
//            HttpSession session = request.getSession();
//            session.invalidate();
//            response.sendRedirect("/demo/index.jsp");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ten_dang_nhap = request.getParameter("ten_dang_nhap");
        String mat_khau = request.getParameter("mat_khau");

        TaiKhoanDatabase db =  new TaiKhoanDatabase(DBContext.getInstance().getConnection());
        TaiKhoan taiKhoan = db.logTaiKhoan(ten_dang_nhap, mat_khau);

        if(taiKhoan!=null){
            HttpSession session = request.getSession();
            session.setAttribute("logTaiKhoan", taiKhoan);
            response.sendRedirect("index.jsp");
        }else{
            out.println("Không tìm thấy người dùng !");
        }


    }
}
