/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Beans.UserAccount;
import Utils.Log;
import Utils.MyUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Utils.DButils;

/**
 * servlet đọc cookies để tự động đăng nhập
 *
 * @author Luc Nguyen by Matkinhig <lucnguyen.hcmut@gmail.com>
 */
@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {

    public CookieFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        UserAccount userInSession = MyUtils.getLoginedUser(session);
        // 
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }

        // Connection đã được tạo trong JDBCFilter.
        Connection conn = MyUtils.getStoredConnection(request);

        // Cờ (flag) để kiểm tra Cookie.
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userName = MyUtils.getUserNameInCookie(req);
            try {
                UserAccount user = DBUtils.findUser(conn, userName);
                MyUtils.storeLoginedUser(session, user);
            } catch (SQLException e) {
                Log.topupError("doFilter", e, "kiểm tra cookies");
            }
            // Đánh dấu đã kiểm tra Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
