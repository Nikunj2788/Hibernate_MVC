package sam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.bean.MainBean;
import sam.dao.MainDao;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String email = request.getParameter("email");

        MainBean mainBean = new MainBean();
        mainBean.setName(name);
        mainBean.setContact(contact);
        mainBean.setEmail(email);

        MainDao mainDao = new MainDao();
        String resultMessage = mainDao.doRegister(mainBean);

        // Redirect to a success page or show a success message
        if ("Data registered successfully".equals(resultMessage)) {
            response.sendRedirect("success.html");
        } else {
            // You might want to handle the error case differently, like displaying an error page.
            response.sendRedirect("error.html");
        }
    }
}

