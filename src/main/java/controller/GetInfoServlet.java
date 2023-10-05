package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetClass;





@WebServlet("/GetInfoServlet")
public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfoServlet() {
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
		String userEntryOne = request.getParameter("userEntryOne");
		String userEntryTwo = request.getParameter("userEntryTwo");
		String path = "/Index.jsp";
		if (userEntryOne.isEmpty() || userEntryTwo.isEmpty() || userEntryOne == null || userEntryTwo == null) {
			getServletContext().getRequestDispatcher(path).forward(request, response);
			return;
		} 
		PetClass wta = new PetClass(userEntryOne, userEntryTwo);
		GetInfoHelper getInfoObj = new GetInfoHelper();
		getInfoObj.insertItem(wta);
		getServletContext().getRequestDispatcher(path).forward(request, response);

		

		
	}

}
