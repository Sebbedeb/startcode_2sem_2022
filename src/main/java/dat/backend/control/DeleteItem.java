package dat.backend.control;

import dat.backend.model.entities.Item;
import dat.backend.model.entities.User;
import dat.backend.model.entities.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteItem", value = "/deleteItem")
public class DeleteItem extends HttpServlet {
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String item_id = request.getParameter("item_id");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();

        ItemFacade.deleteItem(item_id, username, connectionPool);

        List<Item> itemList = ItemFacade.getItems(connectionPool);
        request.setAttribute("itemList", itemList);
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request,response);

    }
}
