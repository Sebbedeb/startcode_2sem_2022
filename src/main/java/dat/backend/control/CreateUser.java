package dat.backend.control;

import dat.backend.model.entities.Item;
import dat.backend.model.entities.User;
import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateUser", value = "/createuser")
public class CreateUser extends HttpServlet {
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("newUsername");
        String password = request.getParameter("newPassword");
        String role = "user";
        HttpSession session = request.getSession();
        try {
            User user = UserFacade.createUser(username, password, role, connectionPool);
            request.setAttribute("user", user);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}
