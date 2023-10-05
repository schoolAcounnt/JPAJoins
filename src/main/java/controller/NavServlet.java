package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetClass;


/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/NavServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetInfoHelper wta = new GetInfoHelper();
		OwnerHelper oh = new OwnerHelper();
		String act = request.getParameter("doThisToItem");

		String path = "/Index.jsp";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				PetClass itemToDelete = wta.searchForItemById(tempId);
				wta.deleteItem(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				PetClass itemToEdit = wta.searchForItemById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/editItem.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}

		} else if (act.equals("addOwner")) {
			request.setAttribute("allItems", wta.showAllItems());
			path = "/addOwner.jsp";

		}else if (act.equals("view all owners")) {
			request.setAttribute("allOwners", oh.showAllItems());
			path = "/allOwners.jsp";

		}
		else if (act.equals("home")) {
			path = "/Index.jsp";

		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
